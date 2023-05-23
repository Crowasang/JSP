<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//MemberBean 객체 생성하여 회원정보를 속성에 설정
	MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	//속성이름 member로 객체를 바인딩
	request.setAttribute("member", member);
%>    

<html>
	<head>
	   <meta charset=”UTF-8">
	   <title>forward</title>
	</head>
	<body>
		<!-- 포워딩 -->
	    <jsp:forward page="member2.jsp"></jsp:forward>
	</body>
</html>
