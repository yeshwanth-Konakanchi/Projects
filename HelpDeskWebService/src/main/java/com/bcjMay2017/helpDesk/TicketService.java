package com.bcjMay2017.helpDesk;


import javax.jws.WebMethod;
import javax.jws.WebService;


import com.bcjMay2017.helpDesk.entity.Ticket;

@WebService
public interface TicketService {
	
	@WebMethod
	public Ticket getTicketByID(int id);

	
}
