package com.javabot.customer.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author  Yeshwanth
 * 
 * Customer Service Integration Testing, when we run this test cases server will start on random port
 * and executes all these test cases
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CustomerControllerIT {

	@Autowired
	private MockMvc mockMvc;
	
	MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	
	@Test
	public void testGetCustomerInfoById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/custid/{custid}", "3"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(contentType))
				.andExpect(jsonPath("$.firstName").value("Java"));
	}

	
	
	@Test
	public void testGetCustomerInfoByEmail() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/email/{email}", "javabot.netflix@gmail.com"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(contentType))
				.andExpect(jsonPath("$.firstName").value("Java"));
	}
}
