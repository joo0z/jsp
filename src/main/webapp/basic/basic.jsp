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
	<% // ��ũ��Ʋ�� : �ڹ� ������ �ۼ��ϴ� ����
	   // Ư�� �޼ҵ� �ȿ��� �����ϴ� �ڹٷ���
		Date date = new Date();
	%>
	<!-- expression : ȭ�鿡 ������ش�.
		=>writer.print()���
		
	 -->
	����ð� : <%=date %>
</body>
</html>