<!DOCTYPE html>
<html lang="en">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
	<title>Spring Boot JSP example</title>
</head>

<body>

	<head>
		<title>Bootstrap Example</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<link href="/lib/fontawesome-free-5.12.1-web/css/all.css" rel="stylesheet">
		<!--load all styles -->
		<script type="text/javascript" src="/lib/fontawesome-free-5.12.1-web/js/all.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		<script type="text/javascript"
			src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>

		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

		<script src="/js/dash1.js"></script>


		<link href="/css/dash1.css" rel="stylesheet">
		<link href="/css/dashheader.css" rel="stylesheet">
		<script src="/js/dash1.js">
		</script>
		<script type="text/javascript">


		</script>
	</head>

	<body>
		<div id="result"></div>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2 sidenav hidden-xs padding-0">
					<h2 align="center">
						<img src="<c:url value="/images/logo3.png"/>" alt="Image2" width="100" height="80">
					</h2>
					<ul id="leftMenu" align="center">
						<!-- 	<li><a href="#">HTML</a></li>   -->
					</ul>
					<div id="leftMenu1"></div>
					<br>
				</div>
				<div class="col-sm-10  padding-0">
					<%@ include file="header.jsp"%>
				</div>
				<div class="col-sm-10 nopadding" style="margin-left:">
					<%-- <%@ include file="menu.jsp"%> --%>
					<%@ include file="product.jsp"%>
				</div>
			</div>
		</div>
	</body>

</html>