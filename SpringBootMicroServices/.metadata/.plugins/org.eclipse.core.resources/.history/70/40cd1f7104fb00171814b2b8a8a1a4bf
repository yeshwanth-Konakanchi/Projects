package com.javabot.webclients.controller;



import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabot.webclients.config.RibbonConfig;
import com.javabot.webclients.domain.Customer;
import com.javabot.webclients.domain.Vehicle;
import com.javabot.webclients.service.VehicleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jagan Reddy
 * 
 * VehicleServiceClient 
 * 
 * configured with ribbon for client side load balancing, swagger for api documentation
 */
@RibbonClient(name = "vehicle-client",configuration = RibbonConfig.class)
@RestController
@RequestMapping("/vehicle")
@Configuration
public class VehicleServiceClient implements VehicleService{
	
	//private static final Logger LOGGER = LogManager.getLogger(VehicleServiceClient.class.getName());
	
	private static final String EUREKA_REGISTRY_VEHICLE_SERVICE_URL = "http://vehicle-service/vehicle";
	private static final String VEHICLE_VIN_END_POINT = "/vin/{vin}";
	
	@Autowired 
	RestTemplate restTemplate;
	
	
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=VEHICLE_VIN_END_POINT,method= RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Finds Vehicle Information By VIN", httpMethod = "GET", notes = "", response = Customer.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Vehicle.class),
			   			   @ApiResponse(code = 500, message = "On Error", response = Response.class),
			   			   @ApiResponse(code = 401, message = "On Unauthorized", response = Response.class),
			   			   @ApiResponse(code = 404, message = " Not Found", response = Response.class) })
	public Vehicle getVehicleInfoByVin(@PathVariable(value = "vin") int vin){
		
		//LOGGER.debug("Authenticated User Name : "+SecurityContextHolder.getContext().getAuthentication().getName());
		return (Vehicle) restTemplate.getForObject(EUREKA_REGISTRY_VEHICLE_SERVICE_URL+VEHICLE_VIN_END_POINT, Vehicle.class,vin);
	}
}
