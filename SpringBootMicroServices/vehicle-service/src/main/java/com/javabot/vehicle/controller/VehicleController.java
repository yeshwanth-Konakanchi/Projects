package com.javabot.vehicle.controller;


import org.apache.catalina.connector.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabot.vehicle.domain.Vehicle;
import com.javabot.vehicle.service.VehicleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author  Yeshwanth
 * 
 * VehicleController has the following behaviors
 * 
 * getCustomerInfoById,
 * getCustomerInfoByEmail
 */

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	private static final Logger LOGGER = LogManager.getLogger(VehicleController.class.getName());
	

		@Autowired
		VehicleService vehicleService;
		
		/**
	     * @param vin
	     * @return Vehicle object
	     * Provides Vehicle information to the consumer for given vin
	     */
		@RequestMapping(value="vin/{vin}",method= RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Finds Vehicle Information By VIN", httpMethod = "GET", notes = " ", response = Vehicle.class)
		@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Vehicle.class),
				   @ApiResponse(code = 500, message = "On Error", response = Response.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = Response.class),
				   @ApiResponse(code = 404, message = " Not Found", response = Response.class) })
		public Vehicle getCustomerInfoById(@PathVariable("vin") String vin) {
			
			LOGGER.info("Getting Vehicle information for Vin : "+vin);
			return vehicleService.getVehicleInfoByVin(vin);
		}
}
