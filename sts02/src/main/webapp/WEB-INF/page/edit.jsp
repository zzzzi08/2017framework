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
				<h1>수정 <small>입력폼을 채워주세요</small></h1>
			</div>
			
			<form action="update.do" method="post" class="form-horizontal">
			  <div class="form-group">
			    <label for="sabun" class="col-sm-2 control-label">사번</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.sabun }" name="sabun" class="sabun" id="sabun" readonly="readonly">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="name" class="col-sm-2 control-label">이름</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.name }" name="name" class="name" id="name">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="pay" class="col-sm-2 control-label">금액</label>
			    <div class="col-sm-10">
			      <input type="text" value="${bean.pay }" name="pay" class="pay" id="pay">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">수정</button>
			    </div>
			  </div>
			</form>
			
		</div>	
		<div class="row footer">
			<div class="col-md-12">
				한빛이엔아이 | 한빛교육센터 | 한빛교육센터
			</div>
		</div>	
	</div>
</body>
</html>