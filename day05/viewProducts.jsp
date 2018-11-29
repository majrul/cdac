<%@page import="com.cdac.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products Listing</title>
</head>
<body>
<table align="center" border="1">

<tr>
	<th>Id</th><th>Name</th><th>Price</th><th>Quantity</th>
</tr>
<%
	List<Product> products = (List<Product>) session.getAttribute("products");
	for(Product product : products) {
%>
		<tr>
			<td><%= product.getId() %></td>
			<td><%= product.getName() %></td>
			<td><%= product.getPrice() %></td>
			<td><%= product.getQuantity() %></td>
		</tr>
<%		
	}
%>
<tr>
	<th colspan="4">
		<button onclick="submit('next')">&gt;&gt;</button>
		<button onclick="submit('prev')">&lt;&lt;</button>
		<a href="productController?view=next">&gt;&gt;</a>
		<a href="productController?view=prev">&lt;&lt;</a>
	</th>
</tr>
</table>

<script>
	function submit(param) {
		
	}
</script>

</body>
</html>