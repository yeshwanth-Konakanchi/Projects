package com.javabot.customer.service;

import com.javabot.customer.domain.Customer;
import com.javabot.customer.domain.CustomerResponse;

/**
 * @author Jagan Reddy
 *
 */
public interface CustomerService {

	public Customer getCustomerInfoById(Integer bankId);

	public Customer getCustomerInfoByEmail(String email);

	public CustomerResponse saveCustomerInfo(Customer customer);

	public CustomerResponse updateCustomerEmail(Customer customer);

	public CustomerResponse deleteCustomer(Customer customer);

}
