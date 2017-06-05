<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel = "stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
	.content{
		font-size: 15pt;
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
    			<a class="btn btn-primary btn-lg" href="list.do" role="button">리스트</a>
			</div>
			<div class="page-header">
				<h1>상세보기 <small>(${bean.sabun }님의 결과)</small></h1>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-offset-3">사번</div>
				<div class="col-md-4">${bean.sabun }</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-offset-3">이름</div>
				<div class="col-md-4">${bean.name }</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-offset-3">날짜</div>
				<div class="col-md-4">${bean.nalja }</div>
			</div>
			<div class="row">
				<div class="col-md-3 col-md-offset-3">금액</div>
				<div class="col-md-4">${bean.pay }</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-md-offset-3">
					<a class="btn btn-default" role="button" href="edit.do?idx=${bean.sabun }">수정</a>
					<a class="btn btn-default" role="button" href="delete.do?idx=${bean.sabun }">삭제</a>
				</div>
			</div>
			
			
		</div>	
		<div class="row footer">
			<div class="col-md-12">
				한빛이엔아이 | 한빛교육센터 | 한빛교육센터
			</div>
		</div>	
	</div>
</body>
</html>