package com.bcjMay2017.helpDesk;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcjMay2017.helpDesk.dao.TicketDao;
import com.bcjMay2017.helpDesk.entity.Ticket;


@Component
@Path("/ticket")
public class TicketServiceImpl  {
	
	@Autowired(required = true)
	public TicketDao ticketDao;
	
	@GET
	@Path("/getTicket/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Ticket getTicketByID(@PathParam("id") int id){
		 
		 List<Ticket> ticket = ticketDao.getTicketDetailsById(id);
		 
		 Ticket  ticketNew= ticket.get(0);

	 return ticketNew;
		 
	 }
}
