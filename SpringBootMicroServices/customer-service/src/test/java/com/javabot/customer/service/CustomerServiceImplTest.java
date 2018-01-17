package com.javabot.customer.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.javabot.customer.domain.Customer;
import com.javabot.customer.repositories.CustomerRepository;
import com.javabot.customer.service.CustomerServiceImpl;

/**
 * @author  Yeshwanth
 *
 */
public class CustomerServiceImplTest {
	
	private CustomerServiceImpl customerServiceImpl;
	
	@Mock
    private CustomerRepository customerRepository;
	
	@Mock
    private Customer  customer;
	
	@Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        customerServiceImpl = new CustomerServiceImpl();
        customerServiceImpl.setCustomerRepository(customerRepository);
    }
	
	 @Test
	 public void testGetCustomerInfoById(){
		 
		 when(customerRepository.findOne(1)).thenReturn(customer);
		 Customer retrievedCustomer = customerServiceImpl.getCustomerInfoById(1);
		 assertThat(retrievedCustomer, is(equalTo(customer)));
	 }
	 
	 @Test
	 public void testGetCustomerInfoByEmail(){
		 
		 when(customerRepository.retrieveCustomerInfoByEmail("javabot.netflix@gmail.com")).thenReturn(customer);		 
		 Customer retrievedCustomer = customerServiceImpl.getCustomerInfoByEmail("javabot.netflix@gmail.com");
		 assertThat(retrievedCustomer, is(equalTo(customer)));
	 }
	 
	 
	 @Test
	 public void testGetCustomerInfoByEmail_invalid(){
		 
		 when(customerRepository.retrieveCustomerInfoByEmail("123456789")).thenReturn(null);		 
		 Customer retrievedCustomer = customerServiceImpl.getCustomerInfoByEmail("123456789");
		 assertThat(retrievedCustomer, is(equalTo(null)));
	 }

}
