<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>속성 설정전</h3>
	userId : ${userId }<br>
	
	set태그를 통해 속성을 저장
	<c:set var="userId" value="brown"/>
	
	<h3>속성 설정 후</h3>
	userId : ${userId }<br>
	
	<br>
	객체의 필드 설정도 가능
	<%
		// MemberVo가 서블릿을 통해 request객체에 설정되었다고 가정
		// 생성하고 난 후 값을 설정하는 부분 없음
		MemberVo memberVo = new MemberVo();
		request.setAttribute("memberVo", memberVo);
	%>
	
	memberVo : ${memberVo } <br><br>
	set 태그를 톻해 scope 객체에 저장된 vo객체의 필드를 수정(setter)<br>
	
	<c:set target="${memberVo}" property="userid" value="sally"/>
	memberVo : ${memberVo } <br><br>
	
	<h3>remove 태그를 통해 scope객체에서 속성 제거</h3>
	<c:remove var="memberVo"/>
	memberVo : ${memberVo } <br>
	
</body>
</html>