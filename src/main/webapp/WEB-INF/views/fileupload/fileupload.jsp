<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	client form method : post enctype="multipart/form-data" 
		server - servlet @MultipartConpig
			   - spring Framework multipartResolver
		-->
	<form action="${cp }/fileupload/upload" method="post" enctype="multipart/form-data">
	    userid : <input type="text" name="userid" value="브라운"> <br>
	    <input type="file" name="file" />
	    <input type="submit" value="Download"/>
	</form>


</body>
</html>