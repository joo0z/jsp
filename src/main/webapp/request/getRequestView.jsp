<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function () {
		
		$("input:radio[name=meth]").click(function(){
		    if($("input:radio[name=meth]:checked").val()=='get'){
			    $('#fo').attr('method', get)
		    }else{
			    $('#fo').attr('method', post)
		    }
		})

	})	
</script>
</head>
<body>
	<%-- 파라미터 : client 서버로 요청을 보낼 때 추가적으로 보낸 값
		  	ex : 로그인 요청시 : 사용자 id, 비밀번호
			
		 파라미터는 내부적으로 Map<String, String[]> 객체로 관리한다.
		 				  파라미터이름, 파라미터값들
		 				  ==> 동일한 이름의 파라미터를 여러개 보낼 수 있다.
		 
		 request객체에 있는 파라미터 관련 메소드 4가지
		 - String getParamter(String param) : param에 해당하는 파라미터값을 조회한다.	
		 									  파라미터맵에서 첫번째 값을 반환
		 - String[] getParamterValues(String param) : param에 해당하는 파라미터값을 반환한다.	
		 
		 - Map<String, String[]> getParamterMap() : request 객체에 생성된 파라미터 맵을 반환
		 
		 - Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환
	 --%>
	 <%-- 한글 파라미터 설정
	 		get : server.xml <Connector URIEncoding="utf-8">
	 		post : request.setCharacterEncoding("utf-8");
	 			   request.getParameter()메소드를 호출하기 전에 설정을 해줘야한다.
	 	
	  --%>
	 
	 <%-- action : 요청을 보낼 경로
	 	  mathod : 요청 방식 (form에서는 GET, POST 두가지만 가능하며 DEFAULT를 GET)
	  --%>
	 <form action="/<%=request.getContextPath() %>request/getRequestResponse.jsp" method="post">
	 	user id :<input type="text" name="userId" value="브라운"><br>
	 	user id :<input type="text" name="userId" value="sally"><br>
	 	user password :<input type="password" name="pass" value="1234"><br>
	 	
	 GET POST두가지를 선택할 수 있는 라디오 버튼을 만들어 <br>
	 FORM전송시 사용자가  GET, POST 방식을 지정할 수 있도록<br>
	 GET <input type="radio" value="GET" id="get" name="meth" checked="checked"> <br>
	 POST <input type="radio" value="POST" id="post" name="meth"> <br><br>
	 
	 	<input type="submit" value="전송" id="sub">
	 </form>
	 
	 
	 

</body>
</html>