<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%-- jsp스크립트 : 서버에서 실행됨
		<% %>, <%= %>
		클라이언트 입장에서 전송되지 않는 부분 (스크립트로 가져올 수 없다.)
	 --%>
	 <%String str ="message"; %>
	 <%String str2 =""; %>
	 <%String str3 ="hello"; %>
	 
<script>
	/*
		서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우 (x)
		서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다.
	*/
	<%=str%> = 'test';
	//<%=str2%> = 'test'; => str = 'message'가져오지 못한다. 
	<%--<%=str2%> = 'test'; --%>
	<!-- jsp주석을 실행하면 서버에서도 인식하지 못한다. -->
	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입 
		서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다. 
		변수로 인식하지 않게 ''안에 넣어줘야 문자열로 인식된다. */
	var msg = '<%=str3%>';
	
</script>
</head>
<body>
</body>
</html>