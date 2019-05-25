package com.paf.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "DELIVER_ID")
	  private Long deliverId;

	  @Column(name = "DELIVER_NAME")
	  private String deliverName;
	  
	  @Column(name = "VEHICLE_NUMBER")
	  private String vehicleNumber;
	  
	  @Column(name = "MOBILE")
	  private String mobile;
	  
	  @Column(name = "ORDER_ID")
	  private long orderId;

	  @Column(name = "DELIVER_DATE")
	  private String deliveryDate;
	  
	  @Column(name = "DELIVERY_STATUS")
	  private String deliveryStatus;
	  
	  @Column(name = "DELIVERY_ADDRESS")
	  private String deliveryAddress;
	  
	  


	public Delivery(Long deliverId, String deliverName, String vehicleNumber ,String mobile, long orderId, String deliveryDate,
			String deliveryStatus, String deliveryAddress) {
		super();
		this.deliverId = deliverId;
		this.deliverName = deliverName;
		this.vehicleNumber = vehicleNumber;
		this.mobile = mobile;
		this.orderId = orderId;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.deliveryAddress = deliveryAddress;
	}


	public Delivery() {
	    // Default constructor needed by JPA
	  }


	public Long getDeliverId() {
		return deliverId;
	}


	public void setDeliverId(Long deliverId) {
		this.deliverId = deliverId;
	}


	public String getDeliverName() {
		return deliverName;
	}


	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	

}
