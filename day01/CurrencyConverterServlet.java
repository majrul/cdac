package com.cdac.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyConverterServlet
 */
@WebServlet("/conversion.karo.jaldi")
public class CurrencyConverterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading form data
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		//processing it
		double result = 0;
		if(from.equals("USD") && to.equals("INR"))
			result = amount * 74.74;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(amount + " " + from + " = " + result + " " + to);
		out.println("</body></html>");
		
	}

}
