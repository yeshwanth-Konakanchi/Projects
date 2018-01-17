package com.crmindz.helpdesk.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.crmindz.helpdesk.DAO.HelpDeskDAO;
import com.crmindz.helpdesk.entity.Ticket;



@WebService(endpointInterface = "com.crmindz.helpdesk.service.TicketService" , serviceName = "ticketSoapService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	public HelpDeskDAO helpDeskDAO;
	
	public Ticket getTicketByID(int id){
		 
		 List<Ticket> ticket = helpDeskDAO.getTicketDetailsById(id);
		 
		// System.out.println(ticket.get(0).getComments());
		 
		 Ticket  ticketNew= ticket.get(0);
		 return ticketNew;
		 
	 }
}