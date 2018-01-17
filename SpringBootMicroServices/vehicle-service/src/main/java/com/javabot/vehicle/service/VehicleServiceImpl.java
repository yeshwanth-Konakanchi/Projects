package com.javabot.vehicle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabot.vehicle.domain.Vehicle;
import com.javabot.vehicle.repositories.VehicleRepository;

/**
 * @author  Yeshwanth
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService{
	
	VehicleRepository vehicleRepository;
	
	@Autowired
	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Vehicle getVehicleInfoByVin(String vin) {
		
		return vehicleRepository.findOne(vin);
	}

}
