<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="resources/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/day03/">
					<p>한빛교육센터</p>
				</a>
			</div>
			<a class="navbar-text">MENU1</a> <a class="navbar-text">MENU2</a> 
			<aclass="navbar-text" href="/day03/list">GUEST</a>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="/day03/">Home</a></li>
				<li><a href="/day03/list">List</a></li>
			</ol>
		</div>

		<div class="row">
			<div class="col-md-4">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">메뉴</h3>
					</div>
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="/day03/list">목록</a></li>
							<li><a href="/day03/guest">글쓰기</a></li>
						</ul>
					</div>
					<div class="panel-footer"></div>
				</div>


			</div>
			<div class="col-md-8">
				<div class="page-header">
					<h1>
						목 록 <small>리스트페이지</small>
					</h1>
				</div>
				<table class="table table-hover">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>날짜</th>
						<th>금액</th>
					</tr>
					<c:forEach items="${alist }" var="bean">
						<tr>
							<td><a href="guest/${bean.sabun }">${bean.sabun }</a></td>
							<td><a href="guest/${bean.sabun }">${bean.name }</a></td>
							<td><a href="guest/${bean.sabun }">${bean.nalja }</a></td>
							<td><a href="guest/${bean.sabun }">${bean.pay }</a></td>
						</tr>
					</c:forEach>


				</table>
			</div>
		</div>
	</div>
</body>
</html>