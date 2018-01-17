package com.crmindz.helpdesk.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.crmindz.helpdesk.entity.LoginDetails;
import com.crmindz.helpdesk.entity.Ticket;
import com.crmindz.helpdesk.entity.User;


/**
 * @author Yeshwanth Konakanchi
 * 
 *         HelpDeskDAOImpl class implements the methods in HelpDeskDAO interface
 *         to create, update and retrieve user and ticket data from database
 */

@Repository
public class HelpDeskDAOImpl implements HelpDeskDAO {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	/**
	 * registerUser method is used to save the details of the user in database
	 * and returns the registration to be either success or not
	 */

	public String registerUser(User user) {

		String query3 = "select userName, password, userType from Login where userName = ?";

		Object[] args3 = new Object[] { user.getLogin().getUserName() };

		List<LoginDetails> loginDetails = jdbcTemplate.query(query3, args3, new RowMapper<LoginDetails>() {
			public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.setUserName(rs.getString("userName"));
				loginDetails.setPassword(rs.getString("password"));
				loginDetails.setUserType(rs.getString("userType"));
				return loginDetails;
			}

		});

		if (loginDetails.isEmpty()) {

			SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
			
			insert.setGeneratedKeyName("User_ID");

			Map<String, Object> data = new HashMap<String, Object>();
			
			data.put("firstName", user.getFirstName());
			data.put("lastName", user.getLastName());
			data.put("phoneNumber", user.getPhoneNumber());
			data.put("emailId", user.getEmailId());

			List<String> columns = new ArrayList<String>();
			
			columns.add("firstName");
			columns.add("lastName");
			columns.add("phoneNumber");
			columns.add("emailId");

			insert.setTableName("User");
			insert.setColumnNames(columns);
			Number id = insert.executeAndReturnKey(data);

			String query1 = "insert into Address (addressLine1, addressLine2, city, state, zip, user_User_ID) values (?,?,?,?,?,?)";
			
			Object[] args1 = new Object[] { user.getAddress().getAddressLine1(), user.getAddress().getAddressLine2(),
					user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getZip(), id };
			
			jdbcTemplate.update(query1, args1);

			String query2 = "insert into Login (userName, password, userType, user_User_ID) values (?,?,?,?)";
			
			Object[] args2 = new Object[] { user.getLogin().getUserName(), user.getLogin().getPassword(),
					user.getLogin().getUserType(), id };

			jdbcTemplate.update(query2, args2);

			return "Registration Successful, please login to continue";

		} else {

			return "User name already exists!! ";
		}
	}
	

	/**
	 * getLoginDetails method returns the login details from the database based
	 * on user name
	 */
	public List<LoginDetails> getLoginDetails(LoginDetails login) {

		String query = "select userName, password, userType from Login where userName = ?";

		Object[] args = new Object[] { login.getUserName() };

		List<LoginDetails> loginDetails = jdbcTemplate.query(query, args, new RowMapper<LoginDetails>() {
			public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.setUserName(rs.getString("userName"));
				loginDetails.setPassword(rs.getString("password"));
				loginDetails.setUserType(rs.getString("userType"));
				return loginDetails;
			}

		});

		return loginDetails;

	}
	
	

	/**
	 * getStatesInfo returns the list of maps that contains the states name and
	 * value info
	 */
	public List<Map<String, String>> getStatesInfo() {
		String sql = "select * from states";

		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);

		List<Map<String, String>> stateInfo = new ArrayList<Map<String, String>>();

		for (Map<String, Object> row : resultSet) {
			
			Map<String, String> states = new HashMap<String, String>();
			
			states.put("value", (String) row.get("stateVal"));
			states.put("name", (String) row.get("stateName"));
			
			stateInfo.add(states);
		}

		return stateInfo;
	}
	
	

	/**
	 * getUserTypeInfo method returns the list of maps that contains the user
	 * type info
	 */
	public List<Map<String, String>> getUserTypeInfo() {
		String sql = "select * from userType";

		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);

		List<Map<String, String>> userInfo = new ArrayList<Map<String, String>>();

		for (Map<String, Object> row : resultSet) {
			Map<String, String> userType = new HashMap<String, String>();
			userType.put("value", (String) row.get("userTypeVal"));
			userType.put("name", (String) row.get("userType"));
			userInfo.add(userType);
		}

		return userInfo;
	}
	
	

	/**
	 * getTicketcategoryInfo method returns the list of maps which contains the
	 * ticket category info
	 */
	public List<Map<String, String>> getTicketcategoryInfo() {
		String sql = "select * from ticketCategory";

		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql);

		List<Map<String, String>> ticketCategory = new ArrayList<Map<String, String>>();

		for (Map<String, Object> row : resultSet) {
			
			Map<String, String> tcktCategory = new HashMap<String, String>();
			
			tcktCategory.put("value", (String) row.get("ticketCategoryVal"));
			tcktCategory.put("name", (String) row.get("ticketCategory"));
			
			ticketCategory.add(tcktCategory);
		}

		return ticketCategory;
	}
	
	

	/**
	 * getTicketSubcategoryInfo method returns the list of maps which contains
	 * the ticket sub category info
	 */
	public List<Map<String, String>> getTicketSubcategoryInfo(String ticketCategoryVal) {

		String sql1 = "select ticketCategoryID from ticketCategory where ticketCategoryVal = ?";

		int id = jdbcTemplate.queryForObject(sql1, new Object[] { ticketCategoryVal }, Integer.class);

		String sql = "select * from ticketSubCategory where ticketCategory_ticketCategoryID = ?";

		Object[] args = new Object[] { id };

		List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(sql, args);

		List<Map<String, String>> ticketCategory = new ArrayList<Map<String, String>>();

		for (Map<String, Object> row : resultSet) {
			
			Map<String, String> tcktCategory = new HashMap<String, String>();
			
			tcktCategory.put("value", (String) row.get("ticketSubCategoryVal"));
			tcktCategory.put("name", (String) row.get("ticketSubCategory"));
			
			ticketCategory.add(tcktCategory);
		}

		return ticketCategory;
	}
	
	

	/**
	 * saveTicketInfo method saves the ticket info based on the login ID with
	 * ticket object and session attribute as parameters
	 * 
	 */
	public void createTicket(Ticket ticket, String sessionAttr) {

		String sql = "select Login_ID from login where userName = ?";
		int id = jdbcTemplate.queryForObject(sql, new Object[] { sessionAttr }, Integer.class);

		String query = "insert into Ticket (ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments, login_Login_ID) values (?,?,?,?,?,?,?,?)";
		
		Object[] args = new Object[] { ticket.getTicketCategory(), ticket.getTicketSubCategory(), ticket.getSubject(),
				ticket.getDescription(), ticket.getStatus(), ticket.getTicketReferenceNo(), ticket.getComments(), id };
		
		jdbcTemplate.update(query, args);
	}
	
	

	/**
	 * getFirstName method returns the first name based on the user name passed
	 * as parameter
	 * 
	 */
	public String getFirstName(String userName) {

		String sql = "select user_User_ID from login where userName = ?";
		
		int id = jdbcTemplate.queryForObject(sql, new Object[] { userName }, Integer.class);

		String sql1 = "select firstName from user where User_ID = ?";
		
		String firstName = jdbcTemplate.queryForObject(sql1, new Object[] { id }, String.class);

		return firstName;

	}
	
	

	/**
	 * getTicketDetails method returns the list of tickets based on the user
	 * name passed as parameter
	 * 
	 */
	public List<Ticket> getTicketDetails(String userName) {

		String sql = "select Login_ID from login where userName = ?";
		
		int id = jdbcTemplate.queryForObject(sql, new Object[] { userName }, Integer.class);

		String query = "select ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where login_Login_ID = ?";

		Object[] args = new Object[] { id };

		List<Ticket> ticketDetails = jdbcTemplate.query(query, args, new RowMapper<Ticket>() {
			public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ticket ticketDetails = new Ticket();
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
	
	

	/**
	 * getUserType method returns the user type based on the user name passed as
	 * parameter
	 * 
	 */
	public String getUserType(String userName) {

		String sql = "select userType from login where userName = ?";
		
		String userType = jdbcTemplate.queryForObject(sql, new Object[] { userName }, String.class);

		return userType;

	}
	
	

	/**
	 * getTicketDetailsForEmployee method returns the list of pending tickets
	 * retrieved from database
	 * 
	 */
	public List<Ticket> getTicketDetailsForEmployee() {

		String ticketStatus = "pending";
		
		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where status = ?";

		Object[] args = new Object[] { ticketStatus };

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
	
	

	/**
	 * getApprovedTicketDetailsForEmployee methods updates the ticket table in
	 * database with approved status and comments and returns all the approved
	 * tickets
	 * 
	 */
	public List<Ticket> getApprovedTicketDetailsForEmployee(int ticketID, String comments) {

		String ticketStatus = "approved";

		String sql = "update Ticket set status = ?, Comments=? where ticketID = ?";
		jdbcTemplate.update(sql, ticketStatus, comments, ticketID);

		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where status = ?";

		Object[] args = new Object[] { ticketStatus };

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
	
	

	/**
	 * getRejectedTicketDetailsForEmployee methods updates the ticket table in
	 * database with Rejected status and comments and returns all the Rejected
	 * tickets
	 * 
	 */
	public List<Ticket> getRejectedTicketDetailsForEmployee(int ticketID, String comments) {

		String ticketStatus = "rejected";

		String sql = "update Ticket set status = ?, Comments=? where ticketID = ?";
		
		jdbcTemplate.update(sql, ticketStatus, comments, ticketID);

		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where status = ?";

		Object[] args = new Object[] { ticketStatus };

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
	
	

	/**
	 * getApprovedListTicketDetailsForEmployee method returns list of all
	 * approved tickets
	 * 
	 */
	public List<Ticket> getApprovedListTicketDetailsForEmployee() {

		String ticketStatus = "approved";

		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where status = ?";

		Object[] args = new Object[] { ticketStatus };

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
	
	

	/**
	 * getRejectedListTicketDetailsForEmployee method returns list of all
	 * Rejected tickets
	 * 
	 */
	public List<Ticket> getRejectedListTicketDetailsForEmployee() {

		String ticketStatus = "rejected";

		String query = "select ticketID, ticketCategory, ticketSubCategory, subject, description, status, ticketReferenceNo, Comments from ticket where status = ?";

		Object[] args = new Object[] { ticketStatus };

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
