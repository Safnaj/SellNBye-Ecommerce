package com.paf.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.paf.model.Vehicle;
import com.paf.repository.delivery.VehicleRepository;

public class VehicleDAO {@Autowired
	VehicleRepository vehicleRepository;
	
	/*to save an delivery*/
	
	public Vehicle save(Vehicle vehicle) {
		return  vehicleRepository.save(vehicle);
	}
	
	
	/* search all delivery*/
	
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	
	/*get an vehicle by id*/
	public Vehicle findOne(long Vehicle_ID) {
		return vehicleRepository.findOne(Vehicle_ID);
	}

		/*vehicle an delivery*/
		
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
		}

}
