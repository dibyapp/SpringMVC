<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <c:choose>
    <c:when test="${!empty listDTO}">
    <table border="1">
    <tr>
    <th>Emp No</th><th>Emp Name</th><th>Job</th><th>Salary</th><th>Dept</th>
    </tr>
    <c:forEach var="dto" items="${listDTO}">
    <tr>
    <td>${dto.eno}</td>
    <td>${dto.ename}</td>
    <td>${dto.job}</td>
    <td>${dto.salary}</td>
    <td>${dto.deptno}</td>
    </tr>
    </c:forEach>
    </table><br>
    <c:forEach var="i" begin="1" end="${pagesCount}">
    <a href="report.htm?pageno=${i}">${i}</a> &nbsp;&nbsp;&nbsp;&nbsp;
    </c:forEach>
    </c:when>
    <c:otherwise>
    <h1 style="color:red;text-align:center">Records Not Found</h1>
    </c:otherwise>
    </c:choose>