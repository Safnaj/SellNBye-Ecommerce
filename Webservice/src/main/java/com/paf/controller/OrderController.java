package com.paf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.dao.OrderDAO;
import com.paf.model.Order;
import com.paf.model.Item;

@RestController
@RequestMapping("/shopping")
public class OrderController {

	private final OrderDAO orderDAO;
	
	@Autowired
	OrderController(OrderDAO cartDAO) {
		this.orderDAO = cartDAO;
	}
	
	//Save a Cart
	@PostMapping("/orders")
	public Order createCart(@Valid @RequestBody Order order) {
		return orderDAO.save(order);
	}
	
	//Get All Carts
	@GetMapping("/orders")
	public List<Order> getAllCart(){
		return orderDAO.findAll();
	}
	
	//Get Cart By ID
	@GetMapping("orders/{id}")
	public ResponseEntity<Order> getItemById(@PathVariable(value="id") Long orderId){
		
		Order order= orderDAO.findOne(orderId);
		
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(order);
		
	}
	
	//Update Cart By ID
	@PutMapping("orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value="id") Long orderId,@Valid @RequestBody Order orderDetails){
		
		Order order=orderDAO.findOne(orderId);
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		
		order.setNoOfItems(orderDetails.getNoOfItems());
		order.setTotal(orderDetails.getTotal());
		order.setPayementStatus(orderDetails.getPayementStatus());
		
		Order updateOrder = orderDAO.save(order);
		return ResponseEntity.ok().body(updateOrder);
		
	}
	
	//Delete an Order
	@DeleteMapping("orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable(value="id") Long orderId){
		
		Order order = orderDAO.findOne(orderId);
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		orderDAO.delete(order);
		
		return ResponseEntity.ok().build();
		
	}
	
}


