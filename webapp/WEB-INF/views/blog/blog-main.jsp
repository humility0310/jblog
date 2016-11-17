<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/includes/blogtitle.jsp" />
			<c:import url="/WEB-INF/views/includes/blogheader.jsp" />
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<c:import url="/WEB-INF/views/includes/content.jsp" />
				</div>
				<ul class="blog-list">
					<c:import url="/WEB-INF/views/includes/boardlist.jsp" />
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<c:import url="/WEB-INF/views/includes/blognavi.jsp" />
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/blogfoot.jsp" />
		</div>
	</div>
</body>
</html>