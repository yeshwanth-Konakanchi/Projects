package com.bcjMay2017.helpDesk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bcjMay2017.helpDesk.entity.Ticket;

@Repository
public class TicketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Ticket> getTicketDetailsById(int ticketID) {

		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where ticketID = ?";

		Object[] args = new Object[] { ticketID };

		List<Ticket> ticketDetails = jdbcTemplate.query(query, args, new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ticket ticketDetails = new Ticket();
				ticketDetails.setTicketID(rs.getString("ticketID"));
				ticketDetails.setTicketCategory(rs.getString("ticketCategory"));
				ticketDetails.setTicketSubCategory(rs.getString("ticketSubCategory"));
				ticketDetails.setSubject(rs.getString("subject"));
				ticketDetails.setDescription(rs.getString("description"));
				ticketDetails.setStatus(rs.getString("status"));
				ticketDetails.setTicketReferenceNo(rs.getString("ticketReferenceNo"));
				ticketDetails.setComments(rs.getString("Comments"));
				
				return ticketDetails;
			}

		});

		return ticketDetails;
	}

}
