package com.cdac.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		ServletContext ctx = getServletContext();
 		 		
 		Integer hitCounter = (Integer) ctx.getAttribute("hitCounter");
 		if(hitCounter == null)
 			hitCounter = 0;
 		
 		hitCounter++;
 		ctx.setAttribute("hitCounter", hitCounter);
 		
 		response.getWriter().write("This is Servlet No. 1");
 		response.getWriter().write("Total hits so far : " + hitCounter);
 		
 	}

}
