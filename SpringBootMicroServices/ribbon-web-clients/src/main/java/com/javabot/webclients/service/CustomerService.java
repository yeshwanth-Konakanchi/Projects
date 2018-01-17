package com.javabot.webclients.service;

import com.javabot.webclients.domain.Customer;
import com.javabot.webclients.domain.CustomerResponse;

/**
 *  @author  Yeshwanth
 *
 */
public interface CustomerService {
	
	public Customer getCustomerInfoById(int id);

	public Customer getCustomerInfoByEmail(String email);
	
	public CustomerResponse saveCustomerInfo(Customer customer);
	public CustomerResponse updateCustomerEmail(Customer customer);
	public CustomerResponse deleteCustomer(Customer customer);
}
