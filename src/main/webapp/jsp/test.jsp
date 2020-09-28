<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost/jsp/test.jsp
	jsp 프로젝트 jsp/test.jsp
	
	==> contextPath : jsp
	http://localhost/jsp/test.jsp
	jsp2 프로젝트의 webapp/test.jsp <br>
	
	jsp 프로젝트(contextPath ROOT(/))의 webapp/jsp/test.jsp를 접근하기 위해서는
	http://localhost/jsp/test.jsp로 요청.
	
	jsp2 프로젝트(contextPath jsp)의 webapp/test.jsp를 접근하기 위해서는 
	http://localhost/jsp/test.jsp로 요청
	
	즉 두개의 리소스가 동일한 url을 갖는다.
	이럴때 contextPath를 우선시하여 처리한다. (중요 X)
	
	*url만 보고 경로에 나오는 path가 contextPath인지, webapp 폴더 하위의 디렉토리인지는 알 수 없다.
</body>
</html>