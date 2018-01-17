package com.crmindz.helpdesk.entity;


/**
 * @author Yeshwanth Konakanchi
 *
 *         User entity class holds the user info
 */
public class User {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailId;
	private Address address;
	private LoginDetails login;
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	

	/**
	 * @return the login
	 */
	public LoginDetails getLogin() {
		return login;
	}
	

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(LoginDetails login) {
		this.login = login;
	}

}
