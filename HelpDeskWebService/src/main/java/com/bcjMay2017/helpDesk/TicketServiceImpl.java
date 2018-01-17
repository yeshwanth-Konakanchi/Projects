package com.bcjMay2017.helpDesk;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcjMay2017.helpDesk.dao.TicketDao;
import com.bcjMay2017.helpDesk.entity.Ticket;


@WebService(endpointInterface = "com.bcjMay2017.helpDesk.TicketService" , serviceName = "ticketSoapService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired(required = true)
	public TicketDao ticketDao;
	
	public Ticket getTicketByID(int id){
		 
		 List<Ticket> ticket = ticketDao.getTicketDetailsById(id);
		 
		// System.out.println(ticket.get(0).getComments());
		 
		 Ticket  ticketNew= ticket.get(0);
//		
//		Ticket ticketNew = new Ticket();
	 return ticketNew;
		 
	 }
}
