<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String message = "Welcome to JSP";
%>

<h1></h1>

<h1><%= message %></h1>

<center>
<%
	for(int i=1; i<=7; i++) {
%>
	<font size="<%= i %>">HelloWorld!</font><br/>
<%
	}
%>
</center>

</body>
</html>






