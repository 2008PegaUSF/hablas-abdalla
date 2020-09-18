/**
 * 
 */
package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * @author Abdalla Hablas
 * @date Sep 10, 2020
 */
public class EmployeeController {

	// -------------------------------------------------------------------------------------------------
	/**
	 * Load the proper employee page
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void loadEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("in load employee page");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			// get info from session
			Employee e = (Employee) request.getSession(false).getAttribute("user");
			// get title of employee and load the proper page
			switch (e.getTitle()) {
			case 1: // employee
				System.out.println("employee page is loaded");
				RequestDispatcher rd1 = request.getRequestDispatcher("/employee.html");
				rd1.forward(request, response); // forwards
				break;
			case 2: // direct supervisor
				System.out.println("direct supervisor page is loaded");
				RequestDispatcher rd2 = request.getRequestDispatcher("/directsupervisor.html");
				rd2.forward(request, response); // forwards
				break;
			case 3: // department head
				System.out.println("department head page is loaded");
				RequestDispatcher rd3 = request.getRequestDispatcher("/departmenthead.html");
				rd3.forward(request, response); // forwards
				break;
			case 4: // benefits coordinator
				System.out.println("benefits coordinator page is loaded");
				RequestDispatcher rd4 = request.getRequestDispatcher("/benefitscoordinator.html");
				rd4.forward(request, response); // forwards
				break;
			default:
				break;
			}
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * Get existing employee from the session and send JSON object
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void sendEmployeeJasonObject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		System.out.println("in send employee JSON");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			ObjectMapper mapper = new ObjectMapper();
			Employee emp = (Employee) request.getSession(false).getAttribute("user");
			PrintWriter out = response.getWriter();
			String employeeJSON;
			employeeJSON = mapper.writeValueAsString(emp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(employeeJSON);
			System.out.println(employeeJSON);
			out.flush();
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * get all employees from DB and send as JSON object
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void sendAllEmployeeJasonObject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		System.out.println("in send all employee JSON");
		// make sure we are logged in
		if (request.getSession(false) != null) {
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<Employee> emp = new EmployeeDaoImpl().getAllEmployees();
			PrintWriter out = response.getWriter();
			String employeeJSON;
			employeeJSON = mapper.writeValueAsString(emp);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(employeeJSON);
			System.out.println(employeeJSON);
			out.flush();
		}
	}
}
