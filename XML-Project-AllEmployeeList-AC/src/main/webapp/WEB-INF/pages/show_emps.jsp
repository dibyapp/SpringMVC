<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <c:choose>
    <c:when test="${!empty listDTO}">
    <table align="center" border="1">
    <tr>
    <th>EmpNO</th><th>EmpName</th><th>Desg</th><th>Salary</th><th>DeptNo</th>
    </tr>
    <c:forEach var="dto" items="${listDTO}">
    <tr>
    <td>${dto.empNo}</td>
    <td>${dto.ename}</td>
    <td>${dto.job}</td>
    <td>${dto.salary}</td>
    <td>${dto.deptNo}</td>
    </tr>
    </c:forEach>
    
    </table>
    </c:when>
    
        
  <c:otherwise>
  <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
  
    </c:choose>
    
    <a href="welcome.htm">Home</a>

    