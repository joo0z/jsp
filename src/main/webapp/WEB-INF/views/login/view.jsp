<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="icon" href="../../favicon.ico"> -->

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
 function getCookieValue(cookieName){
	  // 자바스크립트 로직
		var cookies = document.cookie.split("; ") // 쿠키 배열
// 		console.log(cookies)
		for (i = 0; i < cookies.length; i++) {
			cookie = cookies[i].split("=");
			if(cookie[0]==cookieName) {
				return cookie[1];
			}
		}
		// 원하는 쿠키가 없는경우
		return "";
	}   

 function setCookie(cookieName, cookieValue, expires){
	 
	 //"USERNM=brown; path=/; expires=Wed, 07 Oct 2020 00:39:23 GMT"

	 var today = new Date();
	 // 현재날짜에서 미래로 + expires 만큼 한 날짜 구하기
	 today.setDate( today.getDate() + expires );
	 
	 document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
	 console.log(document.cookie);
 }
 // 해당 쿠키의 expires속성을 과거날짜로 변경
 function deleteCookie(cookieName){
	 setCookie(cookieName, "", -1);
 }
	
	// console에 확인
// 	  getCookieValue("usernm") ==> brown
// 	  getCookieValue("rememberme") ==> Y
// 	  getCookieValue("nitexists_cookie") ==> ""

// remeberme가 Y일 때 아이디 저장, 체크박스 체크
window.onload = function (cookieValue){
	if(Cookies.get("REMEMBERME") == "Y"){
		$('#inputEmail').attr('value', Cookies.get("USERNM"));
		$( 'input[name="ck"]' ).prop( 'checked', true );
	}else{
		$( 'input[name="ck"]' ).prop( 'checked', false);
	}
}
$(function(){
	// 버튼 클릭할 때 REMEMBERME 체크박스 체크여부에 따라 쿠키설정 변경
	 $('button').on('click', function(){
		 console.log("button")
		if($('input[name="ck"]').is(":checked") == true){
			Cookies.set("USERNM", $('#inputEmail').val())
			Cookies.set("REMEMBERME", "Y")
			
		}else{
			Cookies.remove("USERNM")
			Cookies.remove("REMEMBERME")
		}
		$("form").submit();
	
	 });
})

</script>
  </head>
  <body>
    <div class="container">
      <form class="form-signin" action="${pageContext.request.contextPath }/login/process" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="userid" id="inputEmail" class="form-control" placeholder="Email address" value="brown" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" value="brownPass" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" name="ck" value="remember-me"> Remember me
          </label>
        </div>
        <button id="but" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>
    </div> <!-- /container -->
    
  </body>
</html>
