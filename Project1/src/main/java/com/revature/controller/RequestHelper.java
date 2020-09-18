/**
 * 
 */
package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Abdalla Hablas
 * @date Sep 10, 2020
 */
public class RequestHelper {

	/**
	 * Handle all request from the user
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in process request");
		// doPost() HANDLER
		// ***************************************************************************
		if (request.getMethod().equals("POST")) {
			System.out.println("in doPost");
			String s = request.getRequestURI();
			System.out.println(s);

			switch (s) {

			case "/Project1/project1/login":
				System.out.println("in log in");
				try {
					LoginController.validateUser(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			// NEW FORM
			// ---------------------------------------------------------------------------
			case "/Project1/project1/newreimbursementrequest":
				System.out.println("in new reimbursement request");
				ReimbursementController.saveNewReimbursementRequest(request, response);
				break;

			// UPDATE REQUEST STATUS/BALANCE
			// ---------------------------------------------------------------------------
			case "/Project1/project1/update":
				System.out.println("in update status");
				ReimbursementController.updateStatusAndBalance(request, response);
				break;
			}

			// doGet() HANDLER
			// ***************************************************************************
		} else if (request.getMethod().equals("GET")) {
			System.out.println("in doGet");
			String s = request.getRequestURI();
			System.out.println(s);
			System.out.println(request.getRequestURL());

			switch (s) {

			// LOGIN / LOGOUT
			// ---------------------------------------------------------------------------
			// load login page
			case "/Project1/project1/login":
				LoginController.loadLogin(request, response);
				break;

			// log out
			case "/Project1/project1/logout":
				System.out.println("in logout");
				LoginController.logout(request, response);
				break;

			// HOME PAGE
			// ---------------------------------------------------------------------------
			case "/Project1/project1/home":
				System.out.println("in home");
				EmployeeController.loadEmployee(request, response);
				break;

			// REIMBERSEMENT FORM
			// ---------------------------------------------------------------------------
			// load reimbursement form
			case "/Project1/project1/reimbursementform":
				System.out.println("in reimbursement form");
				ReimbursementController.loadReimbursementForm(request, response);
				break;

			// REIMBERSEMENT REQUESTS
			// ---------------------------------------------------------------------------
			// load reimbursement requests
			case "/Project1/project1/reimbursementrequest":
				System.out.println("in reimbursement request");
				try {
					ReimbursementController.sendAllReimbersementJasonObj(request, response);
				} catch (ServletException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			// SENDING JSON INFO
			// ---------------------------------------------------------------------------
			// Send employee JSON object to be rendered on the page
			case "/Project1/project1/employeeinfo":
				System.out.println("in employeeinfo");
				try {
					EmployeeController.sendEmployeeJasonObject(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;
			}
		}
	}
}
