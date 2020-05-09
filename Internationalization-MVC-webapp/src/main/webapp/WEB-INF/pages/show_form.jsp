<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:blue;text-align:center">

<form:form modelAttribute="stuCmd">
<spring:message code="sno.label"/><form:input path="sNo"/><br>
<spring:message code="sname.label"/><form:input path="sName"/><br>
<spring:message code="sadd.label"/><form:input path="sAddrs"/><br>

<input type="submit" value="Register"/>
</form:form>

<br>
<a href="?language=hi_IN">Hindi</a>&nbsp; &nbsp;
<a href="?language=fr_FR">French</a>&nbsp; &nbsp;
<a href="?language=de_DE">German</a>&nbsp; &nbsp;

