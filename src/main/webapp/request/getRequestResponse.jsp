<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<h1>GET</h1>
	userId �Ķ���ʹ� brown, sally �ΰ��� �������� getParameter�� ȣ���ϸ� <br>
	ù��° �Ķ���� ���� ��ȯ<br>
	request.getParameter("userId") : <%=request.getParameter("userId") %><br>
	
	String[]�� ��ȯ
	request.getParameterValues("userId") :
	<%
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){
	%>
		<%=userId %>
	<%
		}
	%><br><br>
	
	parameterMap : Map<String, String[]>
	request.getParameterMap() : <%=request.getParameterMap()%><br>
	
	��û�� �����ϴ� �Ķ���� �̸� ����ϱ�
	userId, pass
	<%
		Enumeration<String> pNames = request.getParameterNames();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
	%>
			<%=pName%> = <%request.getHeader(pName); %>
	<%
		}
	%>
	
		
	
</body>
</html>