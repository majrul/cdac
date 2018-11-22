<%@page import="com.cdac.form.RegistrationForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
</head>
<body>
<h2>Please confirm if you have provided us with the correct information. If you wish to change
it please <a href="register.jsp">click here</a> to go back and submit again!</h2>

<%
	RegistrationForm form = (RegistrationForm) session.getAttribute("formData");
%>
Name : <%= form.getName() %> <br/>
Email : <%= form.getEmail() %> <br/>
City : <%= form.getCity() %> <br/>
Pincode : <%= form.getPincode() %> <br/>
Username : <%= form.getUsername() %> <br/>
Password : <%= form.getPassword() %> <br/> we know your password, hahahaha! <br/>

<br/>
<a href="storeRegistrationDetails">Click here</a> to submit your details
</body>
</html>