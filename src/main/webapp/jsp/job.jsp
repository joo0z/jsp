<%@page import="kr.or.ddit.member.model.JobVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.5.1.min.js"></script>
<%	List<JobVo> list = (List<JobVo>) request.getAttribute("jobList");	%>
</head>
<body>
	<table border="2">
		<tr>
			<th>Job_ID</th>
			<th>Job_TITLE</th>
		</tr>
	<%
		for(int i=0; i<list.size(); i++){
				%>
		<tr>
			<td>
				<%=list.get(i).getJob_id()%>
			</td>
			<td>
				<%=list.get(i).getJob_title()%>
		</tr>
		<%}%>
		
	</table>
</body>
</html>