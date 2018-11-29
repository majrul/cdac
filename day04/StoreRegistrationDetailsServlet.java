package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.RegistrationDao;
import com.cdac.exception.DataAccessException;
import com.cdac.form.RegistrationForm;

/**
 * Servlet implementation class StoreRegistrationDetailsServlet
 */
@WebServlet("/storeRegistrationDetails")
public class StoreRegistrationDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RegistrationForm form = (RegistrationForm) session.getAttribute("formData");
		
		RegistrationDao dao = new RegistrationDao();
		try {
			dao.insert(form);
			response.sendRedirect("thankyou.jsp");
		}
		catch(DataAccessException e) {
			//log the exception
			e.printStackTrace();
			response.sendRedirect("register.jsp");
		}
	}

}
