package com.paf.controller;

import java.sql.Timestamp;
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

import com.paf.model.Customer;
import com.paf.dao.CustomerDAO;
@RestController
public class CustomerController {
	
	  private final CustomerDAO customerDAO;
	  
	  @Autowired
	  CustomerController(CustomerDAO customerDAO) {
		    this.customerDAO = customerDAO;
	  }

		/* to save an customer*/
		@PostMapping("/customers")
		public Customer createCustomer(@Valid @RequestBody Customer customer) {
			return customerDAO.save(customer);
		}
		
		/*get all customers*/
		@GetMapping("/customers")
		public List<Customer> getAllCustomers(){
			return customerDAO.findAll();
		}

		/*get customer by customerid*/
		@GetMapping("/customers/{id}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") Long customerid){
			
			Customer customer= customerDAO.findOne(customerid);
			
			if(customer==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(customer);
			
		}
		
		/*update an customer by customerid*/
		@PutMapping("/customers/{id}")
		public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Long customerid,@Valid @RequestBody Customer customerDetails){
			
			Customer customer=customerDAO.findOne(customerid);
			if(customer==null) {
				return ResponseEntity.notFound().build();
			}
			
			customer.setFname(customerDetails.getFname());
			customer.setLname(customerDetails.getLname());
			customer.setPhone(customerDetails.getPhone());
			customer.setAddress(customerDetails.getAddress());
			customer.setCustomerStatus(customerDetails.getCustomerStatus());
			
			Customer updateCustomer=customerDAO.save(customer);
			return ResponseEntity.ok().body(updateCustomer);
			
			
			
		}
		
		/*Delete an customer*/
		@DeleteMapping("/customers/{id}")
		public ResponseEntity<Customer> deleteEmployee(@PathVariable(value="id") Long customerid){
			
			Customer customer = customerDAO.findOne(customerid);
			if(customer==null) {
				return ResponseEntity.notFound().build();
			}
			customerDAO.delete(customer);
			
			return ResponseEntity.ok().build();
			
			
		}
}
