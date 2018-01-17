package com.crmindz.helpdesk.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Yeshwanth Konakanchi
 *
 *          Ticket entity class holds the ticket info
 */

//@XmlRootElement (name="tickets")
@JsonSerialize
public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;
	private String ticketID;
	private String ticketCategory;
	private String ticketSubCategory;
	private String subject;
	private String description;
	private String status;
	private String ticketReferenceNo;
	private String comments;
	
	
	/**
	 * @return the ticketID
	 */
	public String getTicketID() {
		return ticketID;
	}
	
	
	/**
	 * @param ticketID the ticketID to set
	 */
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	
	
	/**
	 * @return the ticketCategory
	 */
	public String getTicketCategory() {
		return ticketCategory;
	}
	
	
	/**
	 * @param ticketCategory the ticketCategory to set
	 */
	public void setTicketCategory(String ticketCategory) {
		this.ticketCategory = ticketCategory;
	}
	
	
	/**
	 * @return the ticketSubCategory
	 */
	public String getTicketSubCategory() {
		return ticketSubCategory;
	}
	
	
	/**
	 * @param ticketSubCategory the ticketSubCategory to set
	 */
	public void setTicketSubCategory(String ticketSubCategory) {
		this.ticketSubCategory = ticketSubCategory;
	}
	
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/**
	 * @return the ticketReferenceNo
	 */
	public String getTicketReferenceNo() {
		return ticketReferenceNo;
	}
	
	
	/**
	 * @param ticketReferenceNo the ticketReferenceNo to set
	 */
	public void setTicketReferenceNo(String ticketReferenceNo) {
		this.ticketReferenceNo = ticketReferenceNo;
	}
	
	
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	
	
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	
}
