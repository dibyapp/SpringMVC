<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 style="color:blue;text-align:center">Corona Registration</h1>
<noscript>
<p style="color:red;text-align:center">Enable JavaScript</p>
</noscript>
<script type="text/javascript" src="js/validation.js"></script>
<form:form modelAttribute="patCmd" onSubmit="return validate(this)">

 <table>
 
 <tr>
 <td>Name</td>
 <td><form:input path="patName"/><form:errors path="patName"/><span id="patNameErr"></span></td>
 </tr>
 <tr>
 <td>Age</td>
 <td><form:input path="age"/><form:errors path="age"/><span id="ageErr"></span></td>
 </tr>
 <tr>
 <td>Location</td>
 <td><form:input path="location"/><form:errors path="location"/><span id="locationErr"></span></td>
 </tr>
 <tr>
 <td>Hospital</td>
 <td><form:input path="hospital"/><form:errors path="hospital"/><span id="hospitalErr"></span></td>
 </tr>
 
 <tr>
 <td><input type="submit" value="register"></td>
 <td><input type="reset" value="cancel"></td>
 </tr>
 <form:hidden path="vflag"/>
 </table>
 </form:form>