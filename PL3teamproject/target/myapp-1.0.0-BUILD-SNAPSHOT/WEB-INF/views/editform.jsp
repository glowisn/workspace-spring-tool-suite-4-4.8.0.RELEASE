<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
	<h1>Edit Form</h1>
	<form:form action="../editok" method="POST" modelAttribute="u">
		<table>
			
				<form:hidden path="seq" />

			<tr>
				<td>Category:</td>
				<td><form:input path="type" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="Name" /></td>
			</tr>
			<tr>
				<td>Context:</td>
				<td><form:input path="context" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>