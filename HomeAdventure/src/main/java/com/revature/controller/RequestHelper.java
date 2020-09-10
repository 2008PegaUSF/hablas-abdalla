/**
 * 
 */
package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Abdalla Hablas
 * @date Sep 9, 2020
 */
public class RequestHelper {
	
	public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String s= request.getRequestURI();
		
		switch (s) {
		
		// front request
		case "/HomeAdventure/api/forward":
			switch(request.getParameter("room")) {
			case "foyer":
				HomeController.goToBed(request, response);
			break;
			case "lobby":
				HomeController.goToFoyer(request, response);
			break;
			case "living":
				HomeController.goToKitchen(request, response);
			break;
			case "kitchen":
			break;
			case "bath":
			break;
			case "bed":
			break;
			default:
				break;
			}
			break;
		
		// back request
		case "/HomeAdventure/api/back":
			switch(request.getParameter("room")) {
			case "foyer":
				HomeController.exitHome(request, response);
			break;
			case "lobby":
			break;
			case "living":
			break;
			case "kitchen":
				HomeController.goToLiving(request, response);
			break;
			case "bath":
			break;
			case "bed":
				HomeController.goToFoyer(request, response);
			break;
			default:
				break;
			}
			
			break;
		
		// right request
		case "/HomeAdventure/api/right":
			switch(request.getParameter("room")) {
			case "foyer":
				HomeController.goToLiving(request, response);
			break;
			case "lobby":
			break;
			case "living":
			break;
			case "kitchen":
			break;
			case "bath":
				HomeController.goToFoyer(request, response);
			break;
			case "bed":
				HomeController.goToKitchen(request, response);
			break;
			default:
				break;
			}
		
		break;
	
		// left request
		case "/HomeAdventure/api/left":
			switch(request.getParameter("room")) {
			case "foyer":
				HomeController.goToBath(request, response);
			break;
			case "lobby":
			break;
			case "living":
				HomeController.goToFoyer(request, response);
			break;
			case "kitchen":
				HomeController.goToBed(request, response);
			break;
			case "bath":
			break;
			case "bed":
			break;
			default:
				break;
			}
			
			break;
		case "/HomeAdventure/api/foyer":
			HomeController.goToFoyer(request, response);

		// all other requests ==> got to lobby
		default:
			if(!request.getMethod().equals("POST")) {
			HomeController.goToLobby(request, response);
			}
			else {
				HomeController.enterHome(request, response);
			}
			
			break;
				
		}
	}
}
