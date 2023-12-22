<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<!-- WEB-INF 안에 있어서 여기서 실행하면 안됨 -->

<div>
	<h2>MVC 실습</h2>
	<hr />
</div>

<div>
	<!-- 컨트롤러로부터 수신한 내용 -->
	<h2>${message }</h2>
</div>

</body>
</html>
































