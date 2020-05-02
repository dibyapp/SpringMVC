<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 style="color: blue; text-align: center">Person Registration</h1>

<form:form modelAttribute="perCmd">
<p style="color:red"/>
<form:errors path="*"/>
	<table align="center">

		<tr>
			<td>Person Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><form:radiobuttons path="gender" items="${gendersList}" /></td>
		</tr>
		<tr>
			<td>Hobbies</td>
			<td><form:select path="gender">
					<form:options items="${hobiesList}"></form:options>
				</form:select></td>
		</tr>
		<tr>
			<td>Qualifications</td>
			<td><form:select path="qualification">
					<form:options items="${qualificationsList}"></form:options>
				</form:select></td>
		</tr>
		<tr>
			<td>Courses</td>
			<td><form:select path="courses" multiple="no">
					<form:options items="${coursesList}"></form:options>
				</form:select></td>
		</tr>
		<tr>
			<td><input type="submit" value="register"></td>
			<td><input type="reset" value="cancel"></td>
		</tr>

	</table>
</form:form>