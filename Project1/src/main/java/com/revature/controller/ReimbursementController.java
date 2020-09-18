/**
 * 
 */
package com.revature.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Request;

import com.revature.daoimpl.ReimbursementDaoImpl;

/**
 * @author Abdalla Hablas
 * @date Sep 11, 2020
 */
public class ReimbursementController {

	// -------------------------------------------------------------------------------------------------
	/**
	 * load new reimbursement FORM page
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void loadReimbursementForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in load reimbursement form page");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			request.getRequestDispatcher("/reimbursementform.html").forward(request, response);
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * get all reimbursement request from DB and send as JSON object
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void sendAllReimbersementJasonObj(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("in send all requests JSON");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Employee e = (Employee) request.getSession(false).getAttribute("user");
			int title = e.getTitle();
			ArrayList<Request> req = null;
			// get the proper request list from DB
			switch (title) {
			case 1: // employee
				req = new ReimbursementDaoImpl().getAllRequestByEmployeeId(e.getEmployeeId());
				break;
			case 2: // direct supervisor
				req = new ReimbursementDaoImpl().getAllRequestByAdmin(title);
				break;
			case 3: // department head
				req = new ReimbursementDaoImpl().getAllRequestByAdmin(title);
				break;
			case 4: // Benefits coordinator
				req = new ReimbursementDaoImpl().getAllRequestBybenfitCord("benco");
				break;
			default:
				break;
			}
			// send JSON object
			PrintWriter out = response.getWriter();
			String requestsJSON;
			requestsJSON = mapper.writeValueAsString(req);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(requestsJSON);
			System.out.println(requestsJSON);
			out.flush();
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * save new Reimbursement request to DB
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void saveNewReimbursementRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in save new request");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			Request burst = null;
			ObjectMapper mapper = new ObjectMapper();
			ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
			// getting the body of the request
			burst = mapper.readValue(request.getInputStream(), Request.class);
			System.out.println(burst.toString());
			// update employee id from session
			Employee emp = (Employee) request.getSession(false).getAttribute("user");
			burst.setemployeeid(emp.getEmployeeId());
			try {
				rdi.addRequest(burst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * update status and balance
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void updateStatusAndBalance(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in update status and balance");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			Request burst = null;
			ObjectMapper mapper = new ObjectMapper();
			ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
			// getting the body of the request
			burst = mapper.readValue(request.getInputStream(), Request.class);
			System.out.println(burst.toString());
			try {
				rdi.updateRequestStatus(burst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
