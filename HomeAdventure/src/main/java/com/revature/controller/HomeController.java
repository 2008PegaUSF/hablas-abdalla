/**
 * 
 */
package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Abdalla Hablas
 * @date Sep 9, 2020
 */
public class HomeController {
	
	// Login method will accept location values from a form, using the
	// .getParameter(*key*), after which it will forward or redirect to the next
	// endpoint
	public static void enterHome(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			HttpSession session = request.getSession();
			session.setAttribute("location", "lobby");
	}

	public static void goToLobby(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/lobby.html");
		rd.forward(request, response); //forwards 
		
	}
	
	public static void goToFoyer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/foyer.html");
		rd.forward(request, response); //forwards 
		
	}
	
	public static void goToBath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/bath.html");
		rd.forward(request, response); //forwards 
	}
	
	public static void goToBed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = request.getRequestDispatcher("/bed.html");
			rd.forward(request, response); //forwards 
	}
	
	public static void goToKitchen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/kitchen.html");
		rd.forward(request, response); //forwards 
	}
	public static void goToLiving(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/living.html");
		rd.forward(request, response); //forwards 
	}
	
public static void exitHome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		response.setStatus(200);
		response.sendRedirect("http://localhost:8080/HomeAdventure/api/");
		
	}
}
