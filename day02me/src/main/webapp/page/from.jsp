<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력/수정 페이지</h1>
	<form action="insert.do" method="post">
		<label for="name">name</label><input type="text" name="name" id="name">
		<label for="nalja">nalja</label><input type="date" name="nalja" id="nalja">
		<label for="cnt">pay</label><input type="number" name="cnt" id="cnt">
		<button>입력</button>
	</form>
</body>
</html>