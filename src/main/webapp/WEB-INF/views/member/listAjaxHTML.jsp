<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceI"%>
<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${memberList }" var="member">
	<tr data-userid="${member.userid}">
		<td>${member.userid }</td>
		<td>${member.usernm }</td>
		<td>${member.alias }</td>
		<!-- format : yyyy-MM-dd -->
		<td><fmt:formatDate value="${member.reg_dt }"
				pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>

$$$$$SEP$$$$$

<c:forEach var="i" begin="1" end="${pages }">
	<c:choose>
		<c:when test="${i == pageVo.page}">
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>
			<li><a href="javascript:memberListAjaxHTML(${i});">${i }</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>
