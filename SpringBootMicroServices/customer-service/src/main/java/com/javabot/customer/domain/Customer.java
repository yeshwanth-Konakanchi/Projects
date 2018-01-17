package com.javabot.customer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author  Yeshwanth
 * 
 * Customer Entity Class
 */


@Entity
@Table(name="customer",schema="javabot")
@JsonIgnoreProperties("customerId")
public class Customer implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	@ApiModelProperty(value = "customerId")
	private int customerId;
	
	@Column(name="first_name")
	@ApiModelProperty(value = "firstName",required = true)
	@JsonProperty(required=true)
	private String firstName;
	
	@Column(name="last_name")
	@ApiModelProperty(value = "lastName",required = true)
	@JsonProperty(required=true)
	private String lastName;
	
	@Column(name="date_of_birth")
	@ApiModelProperty(value = "dateOfBirth",required = true)
	@JsonProperty(required=true)
	private String dateOfBirth;
	
	@Column(name="email")
	@ApiModelProperty(value = "email",required = true)
	@JsonProperty(required=true)
	private String email;
	
	@Column(name="address_ln1")
	@ApiModelProperty(value = "addressLine1")
	private String addressLine1;
	
	@Column(name="address_ln2")
	@ApiModelProperty(value = "addressLine1")
	private String addressLine2;
	
	@Column(name="city")
	@ApiModelProperty(value = "city")
	private String city;
	
	@Column(name="state")
	@ApiModelProperty(value = "state")
	private String state;
	
	@Column(name="zip")
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
