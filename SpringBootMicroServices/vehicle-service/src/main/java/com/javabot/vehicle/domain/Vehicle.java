package com.javabot.vehicle.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author  Yeshwanth
 * 
 * Vehicle Entity Class
 */

@Entity
@Table(name="vehicle",schema="javabot")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 962820568907182138L;

	@Column(name="vehicle_id") 
	@ApiModelProperty(value = "vehicleId")  
	private String vehicleId;

	@Id
	@Column(name="vin")
	@ApiModelProperty(value = "vin")  
	private String vin;

	@Column(name="year") 
	@ApiModelProperty(value = "year")  
	private String year;

	@Column(name="make") 
	@ApiModelProperty(value = "make")  
	private String make;

	@Column(name="model") 
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
