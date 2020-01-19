<%@page import="com.tb.mywebproject.beans.User"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome the page</title>
</head>
<body>
	<form action="login.jsp">
		<input type="text" name="name"> <input type="submit"
			value="Submit">
	</form>
	<%
		Object err = request.getAttribute("error");
		if (err != null) {
	%>
	<div style="background-color: lightgray">
		<span><%=err%></span>
	</div>
	<%
		}
	%>
	


</body>
</html>