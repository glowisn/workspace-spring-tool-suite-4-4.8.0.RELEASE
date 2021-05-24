<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add post</title>
</head>
<body>

	<h1>Add New Post</h1>
	<form action="addok" method="POST">
		<table>
			<tr>
				<td>Category:</td>
				<td><input type="text" name="type" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Context:</td>
				<td><textarea cols="50" rows="5" name="context"></textarea></td>
			</tr>
			<tr>
				<td><a href="list">View All Records</a></td>
				<td align="right"><input type="submit" value="Add Post" /></td>
			</tr>
		</table>
	</form>

</body>
</html>