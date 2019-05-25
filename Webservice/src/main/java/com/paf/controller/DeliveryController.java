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
import org.springframework.web.bind.annotation.RestController;

import com.paf.model.Delivery;
import com.paf.dao.DeliveryDAO;


@RestController
public class DeliveryController {
	 private final DeliveryDAO deliveryDAO;
	
	 @Autowired
	  DeliveryController(DeliveryDAO deliveryDAO) {
	    this.deliveryDAO=deliveryDAO;
	  }
		/* to save an item*/
		@PostMapping("/delivery")
		public Delivery createDelivery(@Valid @RequestBody Delivery delivery) {
			return deliveryDAO.save(delivery);
		}
		
		/*get all items*/
		@GetMapping("/delivery")
		public List<Delivery> getAllDeliverys(){
			return deliveryDAO.findAll();
		}
		/*get item by deliverid*/
		@GetMapping("/delivery/{id}")
		public ResponseEntity<Delivery> getDeliverId(@PathVariable(value="id") Long deliveryId){
			
			Delivery delivery= deliveryDAO.findOne(deliveryId);
			
			if(delivery==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(delivery);
			
		}
		/*update an Delivery by Deliveryid*/
		@PutMapping("/delivery/{id}")
		public ResponseEntity<Delivery> updateDelivery(@PathVariable(value="id") Long DeliverId,@Valid @RequestBody Delivery deliveryDetails){
			
			Delivery delivery = deliveryDAO.findOne(DeliverId);
			if(delivery==null) {
				return ResponseEntity.notFound().build();
			}
			
			delivery.setDeliverId(deliveryDetails.getDeliverId() );
			delivery.setDeliverName(deliveryDetails.getDeliverName());
            delivery.setMobile(deliveryDetails.getMobile());
        	delivery.setOrderId(deliveryDetails.getOrderId());
        	delivery.setDeliveryAddress(deliveryDetails. getDeliveryAddress());
        	delivery.setDeliveryDate(deliveryDetails.getDeliveryDate());
        	delivery.setDeliveryStatus(deliveryDetails.getDeliveryStatus());
        	
        	
			
			Delivery updateDelivery=deliveryDAO.save(delivery);
			return ResponseEntity.ok().body(updateDelivery);
			
			
		}
		/*Delete a delivery*/
		@DeleteMapping("/delivery/{id}")
		public ResponseEntity<Delivery> deleteDelivery(@PathVariable(value="id") Long DeliverId){
			
			Delivery delivery = deliveryDAO.findOne(DeliverId);
			if(delivery==null) {
				return ResponseEntity.notFound().build();
			}
			deliveryDAO.delete(delivery);
			
			return ResponseEntity.ok().build();
			
			
		}

		
}
