<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int n;
		n = Integer.parseInt(request.getParameter("name"));
		for (int i = 1; i <= 10; i++) {
			out.println(n * i);
	%><br>
	<%
		}
	%>
	
</body>
</html>