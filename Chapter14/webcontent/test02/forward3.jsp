<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="sec01.ex01.*, java.util.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	List membersList = new ArrayList();
	//MemberBean 객체 생성하여 회원정보를 속성에 설정
	MemberBean m1 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	// ArrayList에 2명의 정보 저장
	membersList.add(m1);
	membersList.add(m2);
	//request내장 객체에 ArrayList를 속성 이름 membersList로 바인딩
	request.setAttribute("membersList", membersList);
%>    

<html>
	<head>
	   <meta charset=”UTF-8">
	   <title>forward</title>
	</head>
	<body>
		<!-- 포워딩 -->
	    <jsp:forward page="member3.jsp"></jsp:forward>
	</body>
</html>
