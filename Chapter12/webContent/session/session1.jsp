<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	String name=(String)session.getAttribute("name");
 	// JSP에서는 자동으로 세션 객체를 생성하기에
 	// 굳이 getSession() 메서드 호출하여 session을 생성 할 필요가 없다.
 	// 9장 HttpSession session = request.getSession();
 	session.setAttribute("address","부산시 사상구");
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session 내장 객체 테스트1</title>
	</head>
	<body>
		이름은 <%= name %>입니다 .<br>
		<a href = session2.jsp>두 번째 페이지로 이동</a>
	</body>
</html>