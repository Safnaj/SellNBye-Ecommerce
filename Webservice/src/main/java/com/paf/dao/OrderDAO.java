package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Order;
import com.paf.repository.order.OrderRepository;

@Service
public class OrderDAO {
	
	@Autowired
	OrderRepository orderRepository;
	
	//Save Cart
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	//Get All Cart
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	//Find Cart By ID
	public Order findOne(Long orderId) {
		return orderRepository.findOne(orderId);
	}
	
	//Delete a Cart
	public void delete(Order order) {
		orderRepository.delete(order);
	}
	

}
