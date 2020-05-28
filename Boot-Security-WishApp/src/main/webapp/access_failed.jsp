<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <h1 style="color:red; text-align:center">Access Failed</h1>
    <b><%=request.getUserPrincipal().getName() %> is not authorized to access</b>
    
    <br>
    <br>
    <a href="../index.jsp">Home</a>