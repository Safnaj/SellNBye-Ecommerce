package com.paf.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
