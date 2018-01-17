package com.crmindz.helpdesk.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.crmindz.helpdesk.entity.Ticket;



@WebService
public interface TicketService {
	
	@WebMethod
	public Ticket getTicketByID(int id);

	
}

