<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="nav nav-sidebar">
	<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="${pageContext.request.contextPath }/member/memberList">사용자</a></li>
	<li class="active"><a href="${pageContext.request.contextPath }/jobServlet">jobs</a></li>
	<%
		pageContext.getRequest();
	%>
<!-- 	표현식 대신 EL로 ContextPath가져오기 -->
	${pageContext.request.contextPath }
	
</ul>