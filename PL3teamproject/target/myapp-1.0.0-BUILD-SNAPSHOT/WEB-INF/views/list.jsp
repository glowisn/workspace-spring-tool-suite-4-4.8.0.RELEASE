<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mycom.myapp.complain.ComplainDAO,com.mycom.myapp.complain.ComplainVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<link href="<c:url value="/resources/css/stylesheet.css"/>" rel="stylesheet" >
</head>
<body>
<h1>자유게시판</h1>
<div>
<table id="list" width="90%">
<tr>
	<th>Id</th>
	<th>Category</th>
	<th>Name</th>
	<th>Context</th>
	<th>Regdate</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${list}" var="u">
	<tr class="alt">
		<td>${u.getSeq()}</td>
		<td>${u.getType()}</td>
		<td>${u.getName()}</td>
		<td>${u.getContext()}</td>
		<td>${u.getRegdate()}</td>
		<td><a href="editform/${u.seq}">Edit</a></td>
		<td><a href="deleteok/${u.seq}">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="add">Add New Post</a>
</div>
</body>
</html>