<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/public.css">
</head>
<body>
	<%-- �ڹ� ����� öĢ(�ڹٴ� ������ �����̴�.)
		 ������ �������� �ʰ� ����� �� ����.
		 ��ü�� �������� �ʰ� ����� �� ����.
	 	
	 	jsp���� request, reponse��� �̸��� ��ü�� ����� �� �ִ� ����
	 	_jspService �޼ҵ忡 ���ڷ� ������ �Ǿ��ְ�
	 	�츮�� �ۼ��ϴ� ��ũ��Ʋ�� �ڵ�� _jspService�޼ҵ� �ȿ��� �����ؾ� �ȴ�.
	 --%>
	 <%
	 
	 %>
	 <table border ="1">
	 	<tr>
	 		<td>request.getServerName()</td>
	 		<td><%=request.getServerName() %></td>
	 	</tr>
	 	<tr>
	 		<td>request.getServerPort()</td>
	 		<td><%=request.getServerPort()%></td>
	 	</tr>
	 	<tr>
	 		<td>request.getServerPort()</td>
	 		<td><%=request.getRequestURI()%></td>
	 	</tr>
	 	<tr>
	 		<td>request.getMethod()</td>
	 		<td><%=request.getMethod()%></td>
	 	</tr>
	 	<tr>
	 		<td>request.getContextPath(</td>
	 		<td><%=request.getContextPath()%></td>
	 	</tr>
	 </table>
	 <%
	 
	 %>
</body>
</html>