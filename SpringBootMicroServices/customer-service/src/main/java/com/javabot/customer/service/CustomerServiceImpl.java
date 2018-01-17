package com.javabot.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabot.customer.domain.Customer;
import com.javabot.customer.domain.CustomerResponse;
import com.javabot.customer.repositories.CustomerRepository;

/**
 * @author  Jagan Reddy
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerInfoById(Integer id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer getCustomerInfoByEmail(String email) {
		return customerRepository.retrieveCustomerInfoByEmail(email);
	}

	@Override
	public CustomerResponse saveCustomerInfo(Customer customer) {

		if (customerRepository.save(customer) != null) {

			return new CustomerResponse("SUCCESS", " Cutomer Information Saved");
		} else
			return new CustomerResponse("ERROR", " Unablr to save Customer Information");
	}

	@Override
	public CustomerResponse updateCustomerEmail(Customer customer) {

		Customer retrivedCust = customerRepository.retrieveCustomerInfo(customer.getLastName().trim(),
				customer.getDateOfBirth().trim());

		if (retrivedCust != null) {

			if (customerRepository.updateCustomerEmail(customer.getEmail(), retrivedCust.getCustomerId()) == 1) {

				return new CustomerResponse("SUCCESS", " Updated Cutomer Email");
			} else
				return new CustomerResponse("ERROR", "No Cutomer found to Update  Email");
		} else
			return new CustomerResponse("ERROR", "No Cutomer found to Update  Email");

	}

	@Override
	public CustomerResponse deleteCustomer(Customer customer) {

		Customer retrivedCust = customerRepository.retrieveCustomerInfo(customer.getLastName().trim(),
				customer.getDateOfBirth().trim());

		if (retrivedCust != null) {
			customerRepository.delete(retrivedCust.getCustomerId());
			return new CustomerResponse("SUCCESS", " Deleted Cutomer Information");
		} else
			return new CustomerResponse("ERROR", " No Customer Found to delete");

	}

}
