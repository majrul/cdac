<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Aaj ki taarikh : <%= new Date() %></h1>
</body>
</html>
<%
	//response.setHeader("refresh","5");
	//response.setHeader("refresh","5;URL=http://google.co.in");
	
	//TODO : Disable caching using headers
%>


