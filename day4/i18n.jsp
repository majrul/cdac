<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internationalization Demo(i18n)</title>
</head>
<body>

<%
	String lang = request.getParameter("lang");
	if(lang == null)
		lang = "en"; //request.getHeader("accept-language");
	
	Locale locale = new Locale(lang);
	ResourceBundle rBundle = ResourceBundle.getBundle("messages",locale);
	//indirectly we are passing the name of the messages_en/hi.properties file
	String greeting = rBundle.getString("greeting");
	
	String dateFormat = rBundle.getString("dateFormat");
	String currentDate = new SimpleDateFormat(dateFormat).format(new Date());
	
%>
<h1><%= greeting %></h1>
<h2><%= currentDate %></h2>

<a href="i18n.jsp?lang=en">English</a>
<a href="i18n.jsp?lang=hi">Hindi</a>
</body>
</html>