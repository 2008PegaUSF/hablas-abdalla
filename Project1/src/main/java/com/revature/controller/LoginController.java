/**
 * 
 */
package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;

/**
 * @author Abdalla Hablas
 * @date Sep 10, 2020
 */
public class LoginController {

	// -------------------------------------------------------------------------------------------------
	/**
	 * open login page
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void loadLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in load login page");
		request.getRequestDispatcher("/login.html").forward(request, response);
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * validate user
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("in validate user");
		// method guarding (make sure it's secure POST request)
		if (!request.getMethod().equals("POST")) {
			response.setStatus(403);
			response.sendRedirect("https://images.app.goo.gl/GEwXkNu29P5uYoqt5");

		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			EmployeeDaoImpl eImpl = new EmployeeDaoImpl();
			Employee e = eImpl.getEmployeeByUsername(username);
			System.out.println(e);

			// user exist and password match
			if (e != null && e.getPassword().equals(password)) {
				// start a session
				HttpSession session = request.getSession();
				session.setAttribute("user", e);
				System.out.println("sessionID: " + session.getId());

				response.sendRedirect("http://localhost:8080/Project1/project1/home");
			} else {
				// redirect to login page
				response.setStatus(403);
				response.sendRedirect("http://localhost:8080/Project1/project1/login");
			}
		}
	}

	// -------------------------------------------------------------------------------------------------
	/**
	 * log out, terminate the session, and redirect to login page
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.getSession().invalidate();
		System.out.println("session terminated");
		System.out.println(request.getSession(false));
		response.setStatus(200);
		response.sendRedirect("http://localhost:8080/Project1/project1/login");
	}
}
