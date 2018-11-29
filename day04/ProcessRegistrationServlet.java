package com.cdac.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.form.RegistrationForm;
import com.cdac.validation.RegistrationFormValidation;

/**
 * Servlet implementation class ProcessRegistrationServlet
 */
@WebServlet("/processRegistration")
public class ProcessRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1. Collect form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String captchaInput = request.getParameter("captchaInput");
		
		//Step 2. Copy/Collect/Store the form data in an Object
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setName(name);
		registrationForm.setEmail(email);
		registrationForm.setCity(city);
		registrationForm.setPincode(Integer.parseInt(pincode));
		registrationForm.setUsername(username);
		registrationForm.setPassword(password);
		registrationForm.setConfirmPassword(confirmPassword);
		registrationForm.setCaptchaInput(captchaInput);
		
		//Step 3. Store form data in the user session
		HttpSession session = request.getSession();
		session.setAttribute("formData", registrationForm);
	
		//Step 4. Validation
		RegistrationFormValidation validation = new RegistrationFormValidation();
		List<String> errors = validation.validate(registrationForm);
		if(!errors.isEmpty()) {
			session.setAttribute("errors", errors);
			response.sendRedirect("register.jsp");
		}
		else {
			response.sendRedirect("confirmation.jsp");
		}
		
	}

}
