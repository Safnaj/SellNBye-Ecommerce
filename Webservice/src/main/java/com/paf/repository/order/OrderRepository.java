package com.paf.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
