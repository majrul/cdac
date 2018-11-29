<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
<font color="red">
	<%
		List<String> errors = (List<String>) session.getAttribute("errors");
		if(errors != null) {
			for(String error : errors) {
	%>
				<b><%= error %></b> <br/>
	<%
			}
			session.removeAttribute("errors");
		}
	%>
</font>

<form method="post" action="processRegistration">
<h2>Registration Form</h2>
Name : <input type="text" name="name" /><br/>
Email : <input type="text" name="email" /><br/>
City : <input type="text" name="city" /><br/>
Pincode : <input type="text" name="pincode" /><br/>
Username : <input type="text" name="username" /><br/>
Password : <input type="password" name="password" /><br/>
Confirm Password : <input type="password" name="confirmPassword" /><br/>
<img src="captcha.jpg" /><br/>
Enter the captcha text : <input type="text" name="captchaInput" /><br/>
<input type="submit" value="Register" />
</form>
</body>
</html>