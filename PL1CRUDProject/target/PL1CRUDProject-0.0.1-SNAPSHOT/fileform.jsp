<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일추가 - 실전프로젝트 회원관리 V1</title>
<link rel="stylesheet" href="member.css">
</head>
<body>
<form method='post' enctype='multipart/form-data' action='fileupload.jsp'>
	title : <input type = 'text' name='title'/><br/>
	photo : <input type = 'file' name='photo'/><br/>
	<input type = 'submit' name='업로드'/>	
</form>
</body>
</html>