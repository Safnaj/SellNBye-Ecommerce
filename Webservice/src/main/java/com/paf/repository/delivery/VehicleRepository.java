package com.paf.repository.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
