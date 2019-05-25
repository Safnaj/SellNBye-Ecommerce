package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private long id;
	
	@Column(name = "NO_OF_ITEMS")
	private long noOfItems;
	
	@Column(name = "TOTAL")
	private double total;
	
	@Column(name = "ORDER_DATE")
	private Timestamp orderCreatedAt;
	
	@Column(name = "PAYEMENT_STATUS")
	private String payementStatus;

	public Order(long id, long noOfItems, double total, Timestamp orderCreatedAt, String payementStatus) {
		super();
		this.id = id;
		this.noOfItems = noOfItems;
		this.total = total;
		this.orderCreatedAt = orderCreatedAt;
		this.payementStatus = payementStatus;
	}
	
	public Order(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(long noOfItems) {
		this.noOfItems = noOfItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Timestamp getOrderCreatedAt() {
		return orderCreatedAt;
	}

	public void setOrderCreatedAt(Timestamp orderCreatedAt) {
		this.orderCreatedAt = orderCreatedAt;
	}

	public String getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(String payementStatus) {
		this.payementStatus = payementStatus;
	}
	
	
}
