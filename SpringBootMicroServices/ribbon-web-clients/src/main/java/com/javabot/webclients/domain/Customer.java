package com.javabot.webclients.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author  Yeshwanth
 * 
 * Customer Entity Class
 */



@JsonIgnoreProperties("customerId")
public class Customer implements Serializable{
    
	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "customerId")
	private int customerId;
	
	
	@ApiModelProperty(value = "firstName",required = true)
	@JsonProperty(required=true)
	private String firstName;
	
	
	@ApiModelProperty(value = "lastName",required = true)
	@JsonProperty(required=true)
	private String lastName;
	
	
	@ApiModelProperty(value = "dateOfBirth",required = true)
	@JsonProperty(required=true)
	private String dateOfBirth;
	
	
	@ApiModelProperty(value = "email",required = true)
	@JsonProperty(required=true)
	private String email;
	
	
	@ApiModelProperty(value = "addressLine1")
	private String addressLine1;
	
	
	@ApiModelProperty(value = "addressLine1")
	private String addressLine2;
	
	
	@ApiModelProperty(value = "city")
	private String city;
	
	
	@ApiModelProperty(value = "state")
	private String state;
	
	
	@ApiModelProperty(value = "zip")
	private String zip;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
