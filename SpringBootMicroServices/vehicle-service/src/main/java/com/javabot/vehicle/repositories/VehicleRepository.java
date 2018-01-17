package com.javabot.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabot.vehicle.domain.Vehicle;

/**
 * @author  Yeshwanth
 *
 */
public interface VehicleRepository extends JpaRepository<Vehicle,String> {
		
}
