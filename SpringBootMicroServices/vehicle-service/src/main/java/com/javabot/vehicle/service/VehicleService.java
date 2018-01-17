package com.javabot.vehicle.service;

import com.javabot.vehicle.domain.Vehicle;

/**
 * @author  Yeshwanth
 *
 */
public interface VehicleService {

	public Vehicle getVehicleInfoByVin(String vin);
}
