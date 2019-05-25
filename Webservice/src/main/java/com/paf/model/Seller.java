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
@Table(name = "sellers")

public class Seller {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "SELLER_ID")
	  private Long id;

	  @Column(name = "SELLER_FNAME")
	  private String fname;
	  
	  @Column(name = "SELLER_LNAME")
	  private String lname;
	  
	  @Column(name = "SELLER_ADDRESS")
	  private String address;
	  
	  @Column(name = "SELLER_PHONE")
	  private String phone;
	  
	  @Column(name = "EMAIL")
	  private String email;
	  
	  @Column(name = "USER_NAME")
	  private String userName;
	  
	  @Column(name = "_PASSWORD")
	  private String password;
	  
	  @Column(name = "SELLER_STATUS")
	  private String sellerStatus;
	  
	  @Column(name = "SELLER_CREATE_AT")
	  private Timestamp sellerCreateAt;
	  
	  public Seller(Long id, String fname, String lname, String address, String phone, String email, String userName,
				String password, String sellerStatus, Timestamp sellerCreateAt) {
			super();
			this.id = id;
			this.fname = fname;
			this.lname = lname;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.userName = userName;
			this.password = password;
			this.sellerStatus = sellerStatus;
			this.sellerCreateAt = sellerCreateAt;
		}
	  
	  
	  public Seller() {
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


	public String getSellerStatus() {
		return sellerStatus;
	}


	public void setSellerStatus(String sellerStatus) {
		this.sellerStatus = sellerStatus;
	}


	public Timestamp getSellerCreateAt() {
		return sellerCreateAt;
	}


	public void setSellerCreateAt(Timestamp sellerCreateAt) {
		this.sellerCreateAt = sellerCreateAt;
	}
	  
	  


}
