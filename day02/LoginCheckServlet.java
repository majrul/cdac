package com.cdac.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.training.service.LoginService;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean isValid = loginService.isValidUser(username, password);
		
		if(isValid) {
			response.sendRedirect("welcome.html");
		}
		else {
			response.sendRedirect("login.html");
		}
		
	}

}
