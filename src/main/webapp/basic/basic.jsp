<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% // 스크립틀릿 : 자바 로직을 작성하는 공간
	   // 특정 메소드 안에서 구현하는 자바로직
		Date date = new Date();
	%>
	<!-- expression : 화면에 출력해준다.
		=>writer.print()기능
		
	 -->
	현재시간 : <%=date %>
</body>
</html>