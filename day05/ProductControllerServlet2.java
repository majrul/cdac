package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.cdac.model.Product;
import com.cdac.model.ProductDao;

/**
 * Servlet implementation class ProductControllerServlet
 */
@WebServlet("/productController")
public class ProductControllerServlet2 extends HttpServlet {       
   
	//TODO : Store this in the session
	private int currentPosition = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 10;
		
		String view = request.getParameter("view");
		if(view != null) {
			if(view.equals("next"))
				currentPosition += pageSize;
			else if(view.equals("prev"))
				currentPosition -= pageSize;
		}
		
		ProductDao dao = new ProductDao();
		List<Product> products = dao.loadDummyProducts(currentPosition, pageSize);
		
		//convert the list of products in json format
		//for this purpose we will need to use some JSON Parser
		//in this example we will use Jackson
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(products);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonString);
		
	}

}
