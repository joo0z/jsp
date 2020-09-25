<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	요청 헤더 정보 출력
	<%
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = headers.nextElement(); 
			%><br>
			<%=header %> : <%=request.getHeader(header) %><br>
	<%
		}
	%>
</body>
</html>