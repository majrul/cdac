package com.cdac.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello.cdac") //URI/URL
public class HelloServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //MIME
		PrintWriter out = response.getWriter();
		
		out.write("<html><body>");
		out.write("<h1>नमस्ते दुनिया</h1>");
		out.write("</body></html>");
		
		out.close();
	}


}
