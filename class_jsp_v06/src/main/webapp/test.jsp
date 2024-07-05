<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도전 과제</h2>
	<%

		session.invalidate();
		response.sendRedirect("setSession.jsp");

	
	
	%>

</body>
</html>