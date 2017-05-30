<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트페이지</h1>
	
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
<!-- 여기 밑에 부분은 반복할건데 jstl을 사용하기위해 맨위에 태그라이브러리 prefix 만듦
	반복할 부분을 forEach로 쌓아야함  forEach 의 items에 들어가는거는 selectAll의 'list'임
	이름 똑같이 해야하는데 헷갈릴까봐 alist로 바꿈 그러면 selectAll의 list도 alist로 바꿔줘야하고 get도 getAlist로 바꿔야함  -->
	
		<c:forEach items="${list }" var="bean">		
		<tr>
			<td>${bean.sabun }</td>
			<td>${bean.name }</td>
			<td>${bean.nalja }</td>
			<td>${bean.cnt }</td>
		</tr>

		</c:forEach>
	</table>
</body>
</html>