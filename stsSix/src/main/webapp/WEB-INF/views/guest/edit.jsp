<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정페이지</h1>
<form method="post">
	<label for="sabun">사번</label>
	<input type="text" value="${bean.sabun }" name="sabun" id="sabun" /><br/>
	<label for="name">이름</label>
	<input type="text" value="${bean.name }" name="name" id="name" /><br/>
	<label for="pay">금액</label>
	<input type="text" value="${bean.pay }" name="pay" id="pay" /><br/>
	<button>수정</button>
</form>
</body>
</html>