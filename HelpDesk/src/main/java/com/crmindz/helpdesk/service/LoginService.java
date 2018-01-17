package com.crmindz.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmindz.helpdesk.DAO.HelpDeskDAO;
import com.crmindz.helpdesk.entity.LoginDetails;


/**
 * @author Yeshwanth Konakanchi
 * 
 * LoginService class implements methods that involves business logic for validating 
 * user credentials
 *
 */
@Component
public class LoginService {

	@Autowired
	public HelpDeskDAO helpDeskDao;
	

	/**
	 * @param login
	 * @return
	 * 
	 * validateUser methods validates whether user credentials are correct or not by cross checking 
	 * with the details given by the user with the details in database
	 */
	public String validateUser(LoginDetails login) {

		List<LoginDetails> loginDetails = helpDeskDao.getLoginDetails(login);

		if (loginDetails.isEmpty()) {
			return "User name is incorrect!!";
		} else {

			if (loginDetails.get(0).getPassword().equals(login.getPassword())) {

				return loginDetails.get(0).getUserType();
			}

			else {
				return "password is incorrect!!";
			}

		}

	}
	
	

	/**
	 * @param userName
	 * @return
	 * getFirstName method returns the first name of the user
	 */	
	public String getFirstName(String userName) {

		String firstName = helpDeskDao.getFirstName(userName);
		
		return firstName;

	}

}
