package com.javabot.customer.controller;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabot.customer.domain.Customer;
import com.javabot.customer.domain.CustomerResponse;
import com.javabot.customer.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author  Yeshwanth
 * 
 * CustomerController
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class.getName());
	

		@Autowired
		CustomerService customerService;
		
		/**
	     * @param custId
	     * @return Customer object
	     * Provides customer information to the consumer for given customer id
	     */
		@RequestMapping(value="custid/{id}",method= RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Finds Customer Information By Customer Id", httpMethod = "GET", notes = " ", response = Customer.class)
		@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
				   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
				   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
		public Customer getCustomerInfoById(@PathVariable("id") int custId) {
			
			LOGGER.info("Getting Customer info for id : "+custId);
			return customerService.getCustomerInfoById(custId);
		}
	    
	    /**
	     * @param email
	     * @return Customer object
	     * 
	     * Provides customer information to the consumer for given email
	     */
		@RequestMapping(value="/email/{email:.+}",method= RequestMethod.GET, produces = "application/json")
		@ApiOperation(value = "Finds Customer Information By Email", httpMethod = "GET", notes = "  ", response = Customer.class)
		@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
				   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
				   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
		public Customer getCustomerInfoByEmail(@PathVariable("email") String email) {
			
			LOGGER.info("Getting Customer info for email : "+email);
			return customerService.getCustomerInfoByEmail(email);
		}
		
		
		@RequestMapping(value="/save",method= RequestMethod.POST, produces = "application/json")
		@ApiOperation(value = "Persists the provided Customer Information", httpMethod = "POST", notes = "  ", response = CustomerResponse.class)
		@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
				   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
				   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
		public CustomerResponse saveCustomerInfo(@RequestBody Customer customer) throws JsonProcessingException {
			
			LOGGER.info("Save Customer Incoming PayLoad : "+ new ObjectMapper().writeValueAsString(customer));
			return customerService.saveCustomerInfo(customer);
		}
		
		@RequestMapping(value="/updateemail",method= RequestMethod.PUT, produces = "application/json")
		@ApiOperation(value = "Updates the provided Customer Information", httpMethod = "PUT", notes = "  ", response = CustomerResponse.class)
		@ApiResponses(value = {@ApiResponse(code = 201, message = "On success ", response = Customer.class),
				   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
				   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
		public CustomerResponse updateCustomerEmail(@RequestBody Customer customer) throws JsonProcessingException {
			
			LOGGER.info("Update Customer Incoming PayLoad : "+ new ObjectMapper().writeValueAsString(customer));			
			return customerService.updateCustomerEmail(customer);
		}
		
		@RequestMapping(value="/delete",method= RequestMethod.DELETE, produces = "application/json")
		@ApiOperation(value = "Deletes the provided Customer Information", httpMethod = "DELETE", notes = "  ", response = CustomerResponse.class)
		@ApiResponses(value = {@ApiResponse(code = 200, message = "On success ", response = Customer.class),
				   @ApiResponse(code = 500, message = "On Error", response = ResponseEntity.class),
				   @ApiResponse(code = 401, message = "On Unauthorized", response = ResponseEntity.class),
				   @ApiResponse(code = 404, message = " Not Found", response = ResponseEntity.class) })
		public CustomerResponse deleteCustomer(@RequestBody Customer customer) throws JsonProcessingException {
			
			LOGGER.info("Delete Customer Incoming PayLoad : "+ new ObjectMapper().writeValueAsString(customer));			
			return customerService.deleteCustomer(customer);
		}
	}


