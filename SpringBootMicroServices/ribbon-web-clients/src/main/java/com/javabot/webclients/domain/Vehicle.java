package com.javabot.webclients.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author  Yeshwanth
 * 
 * Vehicle Entity Class
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 962820568907182138L;

	@ApiModelProperty(value = "vehicleId")
	private String vehicleId;

	@ApiModelProperty(value = "vin")
	private String vin;

	@ApiModelProperty(value = "year")
	private String year;

	@ApiModelProperty(value = "make")
	private String make;

	@ApiModelProperty(value = "model")
	private String model;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
