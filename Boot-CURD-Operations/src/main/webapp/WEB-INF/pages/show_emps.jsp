<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <c:choose>
    <c:when test="${!empty listDTO}">
    <table align="center" border="1">
    <tr>
    <th>EmpNO</th><th>EmpName</th><th>Desg</th><th>Salary</th><th>DeptNo</th><th>Operations</th>
    </tr>
    <c:forEach var="dto" items="${listDTO}">
    <tr>
    <td>${dto.empNo}</td>
    <td>${dto.ename}</td>
    <td>${dto.job}</td>
    <td>${dto.salary}</td>
    <td>${dto.deptNo}</td>
    <td><a href='update.htm?eno=${dto.empNo}'><img src='images/edit.png' width='30' height='30'></a>&nbsp;
    <a href='delete.htm?eno=${dto.empNo}'><img src='images/delete.png' width='30' height='30'></a>
    </td>
    </tr>
    </c:forEach>
    
    </table>
    </c:when>
    
        
  <c:otherwise>
  <h1 style="color:red;text-align:center">Record Not Found</h1>
  </c:otherwise>
  
    </c:choose>
    
    <h2 style="text-align:center">${resMsg}</h2>
    
    <p style="text-align:center"/>
    <a href="welcome.htm">Home</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='register.htm'><img src='images/add.png' width='30' height='30'></a>

    