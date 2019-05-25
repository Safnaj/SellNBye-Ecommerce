package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.model.Customer;
import com.paf.repository.customer.CustomerRepository;

@Service
public class CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;
	
	/*to save an customer*/
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	/* search all customers*/
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	
	/*get an customer by id*/
	public Customer findOne(Long customerid) {
		return customerRepository.findOne(customerid);
	}
	
	
	/*delete an customer*/
	
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}
}
