package com.cdac.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.training.service.LoginService;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginCheck3")
public class LoginCheckServlet3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean isValid = loginService.isValidUser(username, password);
		
		if(isValid) {
			String rememberMe = request.getParameter("rememberMe");
			//String data = username + ":" + password;
			//Cookie c = new Cookie("logindata", data);
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("username", username);
				Cookie c2 = new Cookie("password", password);
				c1.setMaxAge(60 * 60 * 24);
				c2.setMaxAge(60 * 60 * 24);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else {
			HttpSession session = request.getSession();
			Integer count = (Integer) session.getAttribute("loginAttempts");
			if(count == null)
				count = 0;
			if(count < 5) {
				count ++;
				session.setAttribute("loginAttempts", count);
				response.sendRedirect("login.html");
			}
			else
				response.sendRedirect("blocked.html");
		
		}
		
	}

}
