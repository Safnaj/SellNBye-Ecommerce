package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PAYMENT_ID")
  private Long id;

  @Column(name = "ORDER_ID")
  private int orderId;
  
  @Column(name = "PAYMENT_METHOD")
  private String paymentMethod;
  
  @Column(name = "TRANSACTION_ID")
  private Long transactionId;
  
  @Column(name = "PAYMENT_STATUS")
  private String paymentStatus;
  
  @Column(name = "PAYMENT_CREATE_AT")
  private Timestamp paymentCreateAt;

  

  public Payment(Long id, int orderId,Long transactionId,String paymentMethod, String paymentStatus, Timestamp paymentCreateAt) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.transactionId = transactionId;
	this.paymentMethod = paymentMethod;
	this.paymentStatus = paymentStatus;
	this.paymentCreateAt = paymentCreateAt;
}


public Payment() {
    // Default constructor needed by JPA
  }


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public int getOrderId() {
	return orderId;
}


public void setOrderId(int orderId) {
	this.orderId = orderId;
}


public Long getTransactionId() {
	return transactionId;
}


public void setTransactionId(Long transactionId) {
	this.transactionId = transactionId;
}


public String getPaymentMethod() {
	return paymentMethod;
}


public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}


public String getPaymentStatus() {
	return paymentStatus;
}


public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}


public Timestamp getPaymentCreateAt() {
	return paymentCreateAt;
}


public void setPaymentCreateAt(Timestamp paymentCreateAt) {
	this.paymentCreateAt = paymentCreateAt;
}



}
