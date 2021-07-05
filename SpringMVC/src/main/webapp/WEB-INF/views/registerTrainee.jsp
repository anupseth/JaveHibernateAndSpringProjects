<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<div align="center">
		<h2>Save trainee Detail</h2>

		<form:form method="post" action="addTrainee"
			modelAttribute="traineeCommand">
			<table border="1px">
				<tr>
					<td><form:label path="traineeName">Trainee Name</form:label></td>
					<td><form:input path="traineeName" /></td>
				</tr>
				<tr>
					<td><form:label path="marksScored">Marks Scored</form:label></td>
					<td><form:input path="marksScored" /></td>
				</tr>
				<tr>
					<td><form:label path="contactNumber">Contact Number</form:label></td>
					<td><form:input path="contactNumber" /></td>
				</tr>

				<tr>
					<td><input type="submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>