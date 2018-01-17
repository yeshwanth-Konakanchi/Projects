package com.crmindz.helpdesk.jUnitTests;

import com.crmindz.helpdesk.DAO.HelpDeskDAO;
import com.crmindz.helpdesk.entity.LoginDetails;
import com.crmindz.helpdesk.service.LoginService;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeshwanth Konakanchi
 * 
 *         LoginServiceTest class implements the methods to perform unit tests
 *         on LoginService Class
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

	@InjectMocks
	private LoginService loginService;

	@Mock
	private HelpDeskDAO helpDeskDao;

	/**
	 * testValidateUserWithValidCredentials method tests the validateUser method
	 * in LoginSerivice class unit with valid credentials
	 * 
	 */

	@Test
	public void testValidateUserWithValidCredentials() {

		List<LoginDetails> loginDetails = new ArrayList<LoginDetails>();

		LoginDetails login = new LoginDetails();
		login.setPassword("12345");
		login.setUserName("sam@gmail.com");
		login.setUserType("E");

		loginDetails.add(login);

		when(helpDeskDao.getLoginDetails(Mockito.any(LoginDetails.class))).thenReturn(loginDetails);

		LoginDetails loginCredentials = new LoginDetails();
		loginCredentials.setPassword("12345");

		Assert.assertEquals("E", loginService.validateUser(loginCredentials));

	}

	/**
	 * testValidateUserWithIncorrectPassword method tests validateUser method
	 * unit in LoginService class with invalid password
	 * 
	 */

	@Test
	public void testValidateUserWithIncorrectPassword() {
		List<LoginDetails> loginDetails = new ArrayList<LoginDetails>();

		LoginDetails login = new LoginDetails();
		login.setUserName("sam@gmail.com");
		login.setPassword("12345");
		loginDetails.add(login);

		when(helpDeskDao.getLoginDetails(Mockito.any(LoginDetails.class))).thenReturn(loginDetails);

		LoginDetails loginCredentials = new LoginDetails();
		loginCredentials.setUserName("sam@gmail.com");
		loginCredentials.setPassword("1234");

		Assert.assertEquals("password is incorrect!!", loginService.validateUser(loginCredentials));

	}

	/**
	 * testValidateUserWithIncorrectUserName method tests validateUser method
	 * unit in LoginService class with invalid user name
	 * 
	 */

	@Test
	public void testValidateUserWithIncorrectUserName() {

		List<LoginDetails> loginDetails = new ArrayList<LoginDetails>();

		when(helpDeskDao.getLoginDetails(Mockito.any(LoginDetails.class))).thenReturn(loginDetails);

		LoginDetails loginCredentials = new LoginDetails();

		loginCredentials.setUserName("govinda@gmail.com");
		loginCredentials.setPassword("12345");

		Assert.assertEquals("User name is incorrect!!", loginService.validateUser(loginCredentials));

	}

}
