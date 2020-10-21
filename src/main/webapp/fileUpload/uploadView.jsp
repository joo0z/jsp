<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>파일을 보낼 때 enctype="multipart/form-data" </p>
	<form action="${cp }/fileUpload" method="post" enctype="multipart/form-data">
		userid : <input type="text" name="userid" value="brown"><br>
		file : <input type="file" name="img"><br>
		<!-- 	값을 미리 지정하는것이 불가능 (보안문제) -->
		<button type="submit">전송</button>
	</form>
</body>
</html>