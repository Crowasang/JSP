<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!-- 선언문 작정 -->
<%!
	String name = "김동현";
	public String getName(){
		return name;
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>선언문 연습 - 김동현</title>
	</head>
	<body>
					<!-- 표현식 -->
		<h1>안녕하세요. <%= name %>님!</h1>
	</body>
</html>