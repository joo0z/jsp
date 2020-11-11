<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceI"%>
<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
// 해당 html이 로딩이 완료 되었을 때 실행되는 이벤트 핸들러 함수
$(document).ready(function(){

	// 로딩될 때는 무조건 1페이지를 요청
// 	memberListAjax(1);
		memberListAjaxHTML(1);
	
		// 동적으로 생성된 부분의 이벤트를 줄 때 생성이 끝나고 이벤트를 준다.
		$("#memberList").on('click', 'tr', function(){
			// 실행 확인
			// 		console.log("memberList tr click");
			// data-userid
			var userid = $(this).data("userid");
			console.log("userid : " +  userid);

			document.location="/member/memberContentAjax?userid=" + userid;
			// form테그 이용할 때
//			 		$("#frm").sumbit();
		});
	
	
});


	function memberListAjax(p){
	// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.
	$.ajax({
			url : "/member/listAjax",
			data : {
				page : p,
				pageSize : 5
			},
			//data : "page=1&pageSize=5",
			//data : JSON.stringify({page : 1, pageSize : 5}),  
			//						==> Controller에서 @RequestBody JSON <---> JAVAObject  (마샬링 - 언마샬링)
			method : "get",
			success : function(data) {
				var i = 0;
				// 				console.log(data);
				//memberList tbody영역에 들어갈 html문자열 생성
				var html = "";
				for (var i = 0; i < data.memberList.length; i++) {
					var member = data.memberList[i];

					html += "<tr data-userid='"+ member.userid+"'>";
					html += "	<td>" + member.userid + "</td>";
					html += "	<td>" + member.usernm + "</td>";
					html += "	<td>" + member.alias + "</td>";
					html += "	<td>" + member.fmt_reg_dt + "</td>";
					html += "</tr>";
				}
				$('#memberList').html(html);

				// 페이지 내비게이션 html문자열 동적으로 생성하기	
				var result = "";
				for (var i = 1; i < data.pages + 1; i++) {
					var page = data.pageVo.page;
					var pageSize = data.pageVo.pageSize;

					if (page == i) {
						result += "<li class='active'><span>" + i + "</span></li>";
					} else {
						//<a href= "javascript:memberListAjax(1);"/>
						result += "<li><a href=\"javascript:memberListAjax(" + i + ");\")>" + i + "</a></li>"
					}
				}
				$('.pagination').html(result);
			}

		});
	}



	function memberListAjaxHTML(p){
		// ajax call을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.
		$.ajax({
				url : "/member/listAjaxHTML",
				data : {
					page : p,
					pageSize : 5
				},
				//data : "page=1&pageSize=5",
				//data : JSON.stringify({page : 1, pageSize : 5}),  
				//						==> Controller에서 @RequestBody JSON <---> JAVAObject  (마샬링 - 언마샬링)
				method : "get",
				success : function(data) {
					var html = data.split("$$$$$SEP$$$$$");
					$('#memberList').html(html[0]);
					$('ul.pagination').html(html[1])
					
				}

			});
		}

	
</script>

<div class="row">
	tiles : memberList.jsp
	<div class="col-sm-8 blog-main">
		<br>
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<tbody id="memberList">
					
				</tbody>
			</table>
		</div>

		<a href="${cp }/member/Regist" class="btn btn-default pull-right">사용자
			등록</a> pages : ${pages} page : ${page }
		<div class="text-center">
			<ul class="pagination">
			
			</ul>
		</div>
	</div>
</div>

</html>
