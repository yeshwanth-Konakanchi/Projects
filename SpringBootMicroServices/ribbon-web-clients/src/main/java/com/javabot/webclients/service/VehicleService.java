package com.javabot.webclients.service;

import com.javabot.webclients.domain.Vehicle;

/**
 *  @author  Yeshwanth
 *
 */
public interface VehicleService {
	
	public Vehicle getVehicleInfoByVin(int vin);
}
