<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
$(function(){
	$( "#join-form" ).submit( function(){
		//2-2. 이메일 중복 체크 유무
		if( $( "#img-checkid" ).is( ":visible" ) == false ){
			alert( "이메일 중복 체크를 해야 합니다." );
			return false;
		}
		
		//4. 약관동의
		if( $( "#agree-prov" ).is( ":checked" ) == false ) {
			alert( "약관 동의를 해야 합니다." );
			return false;
		}
		
		return true;
	});
	$( "#id" ).change( function(){
		$("#img-checkid").hide();
		$("#btn-checkid").show();			
	});
	
	$("#btn-checkid").click( function(){
		var id = $( "#id" ).val();
		if( id == "" ) {
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath }/members/api/checkid?id=" + id,
			type: "get",
			dataType: "json",
			data: "",
			//contentType: "application/json",
			success: function( response ) {
				console.log( response );
				if( response.result == "fail" ) {
					console.log( response.message );
					return;
				}
				
				//success
				if( response.data == "exist" ) {
					alert( "이미 존재하는 아이디입니다. 다른 아이디를 사용해 주세요." );
					$("#id").val("").focus();
					return;
				}
				
				// 존재 하지 않은 이메일
				$("#img-checkid").show();
				$("#btn-checkid").hide();
			},
			error: function( jqXHR, status, e ) {
				console.error( status + ":" + e );
			}
		});
	});
});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<form:form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/joinresult" modelAttribute="membersVo">
			<label class="block-label" for="name">이름</label> 
			<!--  input id="name" name="name" type="text" value=""-->
				<form:input path="name" />
			<p style="color:red">
				<form:errors path="name" />
			</p>

		<label class="block-label" for="blog-id">아이디</label> 
		<!-- input id="blog-id" name="id" type="text"-->
		<form:input path="id" />
			<p style="color:red">
				<form:errors path="id" />
			</p>
		<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
		<input id="btn-checkid" type="button" value="id 중복체크"> 

					

		<label class="block-label" for="password">패스워드</label> 
		<!-- input id="password" name="password" type="password" /-->
		<form:input path="password" />
			<p style="color:red">
				<form:errors path="password" />
			</p>


		<fieldset>
			<legend>약관동의</legend>
			<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
			
			
			
			<label class="l-float">서비스 약관에 동의합니다.</label>
		</fieldset>

		<input type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
