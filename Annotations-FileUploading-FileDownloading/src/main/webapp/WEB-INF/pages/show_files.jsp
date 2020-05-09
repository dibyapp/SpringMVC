<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color:blue;text-align:center">List of Uploaded Files</h1>

<c:choose>
<c:when test="${!empty filesList}">
<table align="center">
<tr><th>File Name</th><th>Operation</th></tr>
<c:forEach var="fname" items="${filesList}">
<tr>
<td>${fname}</td>
<td><a href="download.htm?fileName=${fname}">Download</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">No files</h1>
</c:otherwise>
</c:choose>