<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/day02/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/day02/resources/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="/template/header.jsp"></jsp:include>
	<jsp:include page="/template/menu.jsp">
		<jsp:param value="2" name="active"/>
	</jsp:include>
		
		<div class="panel-body">
			<table class="table table-condensed">
				<tr>
					<th>no</th>
					<th>사번</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
				<c:forEach items="${alist }" var="bean">
				<tr>
					<td>${bean.num }</td>
					<td>${bean.sabun }</td>
					<td>${bean.name }</td>
					<td>${bean.nalja }</td>
				</tr>
				</c:forEach>
			</table>
				   	
		</div>
	<jsp:include page="/template/footer.jsp"></jsp:include>
</body>
</html>