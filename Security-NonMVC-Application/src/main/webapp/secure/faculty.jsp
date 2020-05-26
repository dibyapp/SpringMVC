<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<h1 style="color: blue; text-align: center">Faculty Page</h1>
Current UserName is :
<%=request.getUserPrincipal().getName() %>
<br>
<a href="../logout">Logout</a>
<br>
<a href="../index.jsp">Home</a>

