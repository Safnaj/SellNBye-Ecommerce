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
@Table(name = "items")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ITEM_ID")
  private long id;

  @Column(name = "ITEM_NAME")
  private String itemName;
  
  @Column(name = "ITEM_CATEGORY")
  private String itemCategory;
  
  @Column(name = "ITEM_PRICE")
  private double itemPrice;
  
  @Column(name = "ITEM_QUANTITY")
  private int itemQuantity;
  
  @Column(name = "ITEM_STATUS")
  private String itemStatus;
  
  @Column(name = "ITEM_CREATE_AT")
  private Timestamp itemCreateAt;
  
  @Column(name = "SELLER_ID")
  private Long sid;
  
	public Item(long id, String itemName, String itemCategory, double itemPrice, int itemQuantity, String itemStatus,
			Timestamp itemCreateAt,Long sid ) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemStatus = itemStatus;
		this.itemCreateAt = itemCreateAt;
		this.sid = sid;
	}


	Item() {
	    // Default constructor needed by JPA
	  }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemCategory() {
		return itemCategory;
	}


	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}


	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public String getItemStatus() {
		return itemStatus;
	}


	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}


	public Timestamp getItemCreateAt() {
		return itemCreateAt;
	}


	public void setItemCreateAt(Timestamp itemCreateAt) {
		this.itemCreateAt = itemCreateAt;
	}


	public Long getSid() {
		return sid;
	}


	public void setSid(Long sid) {
		this.sid = sid;
	}
	
	

}
