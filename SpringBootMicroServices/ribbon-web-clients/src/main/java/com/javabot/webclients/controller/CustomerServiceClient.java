package com.javabot.webclients.controller;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javabot.webclients.config.RibbonConfig;
import com.javabot.webclients.domain.Customer;
import com.javabot.webclients.domain.CustomerResponse;
import com.javabot.webclients.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author  Yeshwanth
 * 
 * CustomerServiceClient 
 * 
 * configured with ribbon for client side load balancing, swagger for api documentation
 */
@RibbonClient(name = "customer-client",configuration = RibbonConfig.class)
@RestController
@RequestMapping("/customer")
@Configuration
public class CustomerServiceClient implements CustomerService{
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceClient.class.getName());
	
	private static final String EUREKA_REGISTRY_CUSTOMER_SERVICE_URL = "http://customer-service/customer";
	private static final String CUSTOMER_ID_END_POINT = "/custid/{id}";
	private static final String CUSTOMER_EMAIL_END_POINT = "/email/{email:.+}";
	private static final String CUSTOMER_SAVE_END_POINT = "/save";
	private static final String CUSTOMER_UPDATE_EMAIL_END_POINT = "/updateemail";
	private static final String CUSTOMER_DELETE_END_POINT = "/delete";
	
	@Autowired 
	RestTemplate restTemplate;
	
	
	/* (non-Javadoc)
	 * @see com.javabot.webclients.service.CustomerService#getCustomerInfoById(int)
	 */
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=CUSTOMER_ID_END_POINT,method= RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Finds Customer Information By Customer Id", httpMethod = "GET", notes = " ", response = Customer.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
			   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
			   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
			   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
	public Customer getCustomerInfoById(@PathVariable(value = "id") int id){
		
		LOGGER.info("User Authenticated to access endpoint : "+EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_ID_END_POINT);
		return (Customer) restTemplate.getForObject(EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_ID_END_POINT, Customer.class,id);
	}
	
	
	/* (non-Javadoc)
	 * @see com.javabot.webclients.service.CustomerService#getCustomerInfoByEmail(java.lang.String)
	 */
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=CUSTOMER_EMAIL_END_POINT,method= RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Finds Customer Information By Email", httpMethod = "GET", notes = "  ", response = Customer.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
			   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
			   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
			   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
	
	public Customer getCustomerInfoByEmail(@PathVariable(value = "email") String email){
		
		LOGGER.info("User Authenticated to access endpoint : "+EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_EMAIL_END_POINT);
		return (Customer) restTemplate.getForObject(EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_EMAIL_END_POINT, Customer.class,email);
	}
	
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=CUSTOMER_SAVE_END_POINT,method= RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Persists the provided Customer Information", httpMethod = "POST", notes = "  ", response = CustomerResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
			   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
			   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
			   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
	public CustomerResponse saveCustomerInfo(@RequestBody Customer customer){
		
		LOGGER.info("User Authenticated to access endpoint : "+EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_SAVE_END_POINT);
		return (CustomerResponse) restTemplate.exchange(EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_SAVE_END_POINT, HttpMethod.POST, new HttpEntity<>(customer), CustomerResponse.class).getBody();	
	}
	
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=CUSTOMER_UPDATE_EMAIL_END_POINT,method= RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Updates the provided Customer Information", httpMethod = "PUT", notes = "  ", response = CustomerResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 201, message = "On success ", response = Customer.class),
			   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
			   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
			   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
	public CustomerResponse updateCustomerEmail(@RequestBody Customer customer){
		
		
		LOGGER.info("User Authenticated to access endpoint : "+EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_UPDATE_EMAIL_END_POINT);
		return (CustomerResponse) restTemplate.exchange(EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_UPDATE_EMAIL_END_POINT, HttpMethod.PUT, new HttpEntity<>(customer), CustomerResponse.class).getBody();
	}
	
	@Override
	//@Secured({"ROLE_RESTAPI"})
	@RequestMapping(value=CUSTOMER_DELETE_END_POINT,method= RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Deletes the provided Customer Information", httpMethod = "DELETE", notes = "  ", response = CustomerResponse.class)
	@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
			   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
			   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
			   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
	public CustomerResponse deleteCustomer(@RequestBody Customer customer){
		
		LOGGER.info("User Authenticated to access endpoint : "+EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_DELETE_END_POINT);
		return (CustomerResponse) restTemplate.exchange(EUREKA_REGISTRY_CUSTOMER_SERVICE_URL+CUSTOMER_DELETE_END_POINT, HttpMethod.DELETE, new HttpEntity<>(customer), CustomerResponse.class).getBody();	
	}
	
	 
}
