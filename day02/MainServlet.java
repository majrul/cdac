package com.cdac.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.training.service.LoginService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main.page")
public class MainServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String username = "", password = "";
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username"))
					username = cookie.getValue();
				if(cookie.getName().equals("password"))
					password = cookie.getValue();
			}
			//int[] arr = {10, 20, 30};
			//for(int no : arr)
		}
		if(username.isEmpty() && password.isEmpty()) {
			response.sendRedirect("login.html");
		}
		else {
			LoginService loginService = new LoginService();
			boolean isValid = loginService.isValidUser(username, password);
			if(isValid)
				response.sendRedirect("welcome.html");
			else
				response.sendRedirect("login.html");
		}
	}

}
