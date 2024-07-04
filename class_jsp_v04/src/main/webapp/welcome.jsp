<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영해요~</title>
</head>
<body>
	<%
		// http://localhost:8080/jsp/welcome.jsp
		// session 객체를 사용하여 사용자 정보가 여부를 확인하자
		String username = (String)session.getAttribute("username");		
	
		if(username == null || username.trim().isEmpty()){
			// request 객체에서 사용자 정보를 추출 하자
			username = request.getParameter("username");
			if(username != null && !username.trim().isEmpty()) {
				// 세션 객체를 사용해서 사용자 정보를 저장(속성과 값을)
				
				// 폼 데이터 있는지 없는지 확인... 가정 있다면
				session.setAttribute("username", "홍길동");
				session.setAttribute("visitCount", 1);
				
			} else {
				// 사용자가 정상적인 데이터를 보내지 않았다면
				
				Integer visitCount = (Integer) session.getAttribute("visitCount");
				
				if(visitCount == null){
					visitCount = 1;
				}else {
					visitCount++;
				}
				
				application.setAttribute("visitCount", visitCount);

			}
		}
	
	
		
	%>
	
	<h2>환영 합니다, <%= username  %></h2>
	<p>방문 횟수 : <%= session.getAttribute("visitCount")%> </p>
</body>
</html>