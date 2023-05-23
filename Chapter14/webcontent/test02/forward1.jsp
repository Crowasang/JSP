<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 표현식으로 출력하기 위해 회원 정보 가져옴.
	request.setAttribute("id","hong");
	request.setAttribute("pwd","1234");
	// session 내장 객체에 바인딩
	session.setAttribute("name", "홍길동");
	// application 내장 객체에 바인딩
	application.setAttribute("email", "hong@test.com");
%>    

<html>
	<head>
	   <meta charset=”UTF-8">
	   <title>forward</title>
	</head>
	<body>
		<!-- 포워딩 -->
	    <jsp:forward page="member1.jsp"></jsp:forward>
	</body>
</html>
