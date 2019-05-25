package com.paf.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CUSTOMER_ID")
  private Long id;

  @Column(name = "CUSTOMER_FNAME")
  private String fname;
  
  @Column(name = "CUSTOMER_LNAME")
  private String lname;
  
  @Column(name = "CUSTOMER_ADDRESS")
  private String address;
  
  @Column(name = "CUSTOMER_PHONE")
  private String phone;
  
  @Column(name = "EMAIL")
  private String email;
  
  @Column(name = "USER_NAME")
  private String userName;
  
  @Column(name = "_PASSWORD")
  private String password;
  
  @Column(name = "CUSTOMER_STATUS")
  private String customerStatus;
  
  @Column(name = "CUSTOMER_CREATE_AT")
  private Timestamp customerCreateAt;



public Customer(Long id, String fname, String lname, String address, String phone, String email, String userName,
		String password, String customerStatus, Timestamp customerCreateAt) {
	super();
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.address = address;
	this.phone = phone;
	this.email = email;
	this.userName = userName;
	this.password = password;
	this.customerStatus = customerStatus;
	this.customerCreateAt = customerCreateAt;
}


Customer() {
    // Default constructor needed by JPA
  }


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getFname() {
	return fname;
}


public void setFname(String fname) {
	this.fname = fname;
}


public String getLname() {
	return lname;
}


public void setLname(String lname) {
	this.lname = lname;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getCustomerStatus() {
	return customerStatus;
}


public void setCustomerStatus(String customerStatus) {
	this.customerStatus = customerStatus;
}


public Timestamp getCustomerCreateAt() {
	return customerCreateAt;
}


public void setCustomerCreateAt(Timestamp customerCreateAt) {
	this.customerCreateAt = customerCreateAt;
}



}
