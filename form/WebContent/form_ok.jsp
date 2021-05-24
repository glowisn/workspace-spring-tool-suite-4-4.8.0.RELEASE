<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<caption>회원가입 데이터 항목<br></caption>
<%
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String email_id=request.getParameter("email_id");
String email_addr=request.getParameter("email_addr");
String id=request.getParameter("id");
String password=request.getParameter("password");
String birthday=request.getParameter("birthday");
String gender=request.getParameter("gender");
String textarea=request.getParameter("textarea");
out.println("이름: "+name + "<br>");
out.print("이메일: "+email_id);
out.println(" @ " + email_addr + "<br>");
out.println("아이디: "+id + "<br>");
out.println("비밀번호: "+password + "<br>");
out.println("생년월일: "+birthday + "<br>");
out.println("성별: "+gender + "<br>");
out.println("자기소개: "+textarea + "<br>");
%>
</body>
</html>