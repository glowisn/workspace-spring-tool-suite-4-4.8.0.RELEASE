<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.crud.dao.MemberDAO,com.crud.bean.MemberVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>실전프로젝트 회원관리 V1</title>
<link rel="stylesheet" type="text/css" href="member.css">
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deletepost.jsp?id=' + id;
	}
</script>
</head>
<body>

<div class="header">
	<h1>멤버 목록</h1>
</div>

<table id="list" width="90%">
<tr>
	<th>#</th>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>Regdate</th>
	<th>Edit</th>
	<th>Delete</th>
	<th>정보 보기</th>
</tr>
<%
	MemberDAO boardDAO = new MemberDAO();
	List<MemberVO> list = boardDAO.getList();
	request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.getSid()}</td>
		<td>${u.getUserid()}</td>
		<td>${u.getUsername()}</td>
		<td>${u.getEmail()}</td>
		<td>${u.getRegdate()}</td>
		<td><a href="editform.jsp?id=${u.getSid()}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.getSid()}')">Delete</a></td>
		<td><a href="view.jsp?id=${u.getSid()}">View</a></td>
	</tr>
</c:forEach>
</table>

<br/><a href="addform.jsp">Add New Post</a>
</body>
</html>