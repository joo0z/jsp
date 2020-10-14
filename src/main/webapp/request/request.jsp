<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
</head>
<body>
	<%-- 자바 언어의 철칙(자바는 굉장히 정적이다.)
		 변수를 선언하지 않고 사용할 수 없다.
		 객체를 생성하지 않고 사용할 수 없다.
	 	
	 	jsp에서 request, reponse라는 이름의 객체를 사용할 수 있는 것은
	 	_jspService 메소드에 인자로 선언이 되어있고
	 	우리가 작성하는 스크립틀릿 코드는 _jspService메소드 안에서 실행해야 된다.
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
	 		<td>${pageContext.request.contextPath }</td>
	 	</tr>
	 </table>
	 <%
	 
	 %>
</body>
</html>