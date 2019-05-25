package com.paf.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "VEHICLE_ID")
	  private long vehicleId;

	  @Column(name = "VEHICLE_NUMBER")
	  private String vehicleNumber;
	  
	  @Column(name = "VEHICLE_TYPE")
	  private String vehicleType;
	 
	 


	public Vehicle(long vehicleId, String vehicleNumber, String vehicleType)
			 {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this. vehicleType=vehicleType;
		
	}


	public Vehicle() {
	    // Default constructor needed by JPA
	  }


	public long getVehicleId() {
		return vehicleId ;
	}


	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getVehicleNumber() {
		return vehicleNumber ;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber= vehicleNumber;
	}



	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}
