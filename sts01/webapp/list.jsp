<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
	.alert{
			display: ${param.display ?"block" :"none"};
		}
</style>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous">
</script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
  
</head>
<body>
<div class="alert alert-success" role="alert">${param.msg }</div>
	<div class="container">
		<div class="row header">
			<div class="col-md-12">
				<h1>한빛교육센터</h1>
			</div>
		</div>	
		<div class="row content">
			<div class="jumbotron">
 				 <h1>환영합니다</h1>
 				 <p>한빛교육센터 홈페이지입니다</p>
    			<a class="btn btn-primary btn-lg" href="add.do" role="button">글쓰기</a>
			</div>
			
			<div class="page-header">
				<h1>게시판 <span>글을 작성합니다</span></h1>
			</div>
			<table class="table table-striped">
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>날짜</th>
					<th>금액</th>
				</tr>
				<c:forEach items="${alist }" var="bean">
				<tr>
					<td>${bean.sabun }</td>
					
					<td>
						<a href="detail.do?idx=${bean.sabun }">
						${bean.name }
						</a>
					</td>
					<td>${bean.nalja }</td>
					<td>${bean.pay }</td>
				</tr>
				</c:forEach>
			</table>
			
			
		</div>	
		<div class="row footer">
			<div class="col-md-12">
				한빛이엔아이 | 한빛교육센터 | 한빛교육센터
			</div>
		</div>	
	</div>
</body>
</html>