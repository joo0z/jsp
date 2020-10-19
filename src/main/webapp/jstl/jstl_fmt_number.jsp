<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		// c태그 표현법
		//<c:set var="price" value="100000"/>
		request.setAttribute("price", 100000);
	
	%>
	<h3>${locale.value }사용하는 locale os를 기준으로 표기법이 변한다.</h3>
	<fmt:setLocale value="de_DE"/>
	
<!-- 	숫자를 문자로 바꾸는 formating -->
	price=${price }	<br>
	price - type-number : <fmt:formatNumber value="${price }" type="number"/> 문자열 포메팅<br>
	price - type-percent : <fmt:formatNumber value="1" type="percent"/> 100% => 1로 봤을 때 <br>
	price - type-currency : <fmt:formatNumber value="${price }" type="currency"/> 화폐문자표기<br>
	price - pattern : <fmt:formatNumber value="${price }" pattern="00,0000.00"/> 표기법을 정하는 방법 <br><br>
	
<!-- 	문자를 숫자로 변경 (파라미터 처리) -->
	parseNumber : <fmt:parseNumber value="100.000,52" /><br>
	parseNumber 속성으로 표현 : <fmt:parseNumber value="100.000,52" var="num"/>num = ${num }<br>
	
</body>
</html>