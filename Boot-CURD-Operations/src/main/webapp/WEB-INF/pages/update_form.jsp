<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <form:form modelAttribute="empCmd">
    <table bgcolor="cyan" align="center">
    <tr><td>Employee No.</td><td><form:input path="empNo" readonly="true"/></td></tr>
    <tr><td>Employee Name</td><td><form:input path="ename"/></td></tr>    
    <tr><td>Employee Job</td><td><form:input path="job"/></td></tr>    
    <tr><td>Employee Salary</td><td><form:input path="salary"/></td></tr>    
    <tr><td>Employee DeptNo</td><td><form:input path="deptNo"/></td></tr>    
    <tr><td colspan="2"> <input type="submit" value="Update"></td></tr>
    </table>
    </form:form>
    

    <a href="welcome.htm">Home</a>

    