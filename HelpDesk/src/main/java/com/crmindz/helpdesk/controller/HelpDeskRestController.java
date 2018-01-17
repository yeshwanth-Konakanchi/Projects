package com.crmindz.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crmindz.helpdesk.DAO.HelpDeskDAO;
import com.crmindz.helpdesk.entity.Ticket;

/**
 * @author Yeshwanth Konakanchi
 *
 */

@Controller
public class HelpDeskRestController {
	
	@Autowired
	public HelpDeskDAO helpDeskDaoImpl;
	
	 @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
	  public @ResponseBody Ticket getTicketbyId(@PathVariable("id") int id){
		 
		 List<Ticket> ticket = helpDeskDaoImpl.getTicketDetailsById(id);
		 
		 
		 Ticket  ticketNew= ticket.get(0);
		 return ticketNew;
		 
	 }
	
}
