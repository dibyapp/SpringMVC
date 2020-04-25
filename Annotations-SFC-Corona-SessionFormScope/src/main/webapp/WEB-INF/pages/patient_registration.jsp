<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 style="color:blue;text-align:center">Corona Registration</h1>

<form:form modelAttribute="patCmd">
 <table>
 
 <tr>
 <td>Name</td>
 <td><form:input path="patName"/></td>
 </tr>
 <tr>
 <td>Age</td>
 <td><form:input path="age"/></td>
 </tr>
 <tr>
 <td>Location</td>
 <td><form:input path="location"/></td>
 </tr>
 <tr>
 <td>Hospital</td>
 <td><form:input path="hospital"/></td>
 </tr>
 
 <tr>
 <td><input type="submit" value="register"></td>
 <td><input type="reset" value="cancel"></td>
 </tr>
 
 </table>
 </form:form>