<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:blue;text-align:center">File Uploading</h1>
<form:form method="POST" enctype="multipart/form-data" modelAttribute="uplCmd">
<table align="center">
<tr><td>Employee Name</td><td><form:input path="ename"/></td></tr>
<tr><td>Photo</td><td><form:input type="file" path="file"/></td></tr>
<tr><td colspan="2"><input type="submit" value="upload"/></tr>
</table>
</form:form>
