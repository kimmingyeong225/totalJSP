<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 예제</title>
</head>
<body>
	<h1>JSTL 예제</h1>
	
	<% // 스크립트 릿 대신에 <c:set...> 태그를 사용할 수 있다 %>
	
	<c:set var="message" value="안녕하세요 JSTL!!! "/>
	<p>메시지 : </p><c:out value="${message}"/>
	
	<!-- IF  -->
	<c:if test="${messate != null}}">
		<p>메시지 값이 null 아닙니다</p>
	</c:if>

	<!-- foreach -->
	<c:forEach var="i" begin="1" end= "10">
		<p>Number : ${i}</p>
		
	</c:forEach>
	
	<h2>JSTL Formatting Example</h2>
	<c:set var="now" value="<%=new Date() %>"/>
	<fmt:formatDate var="formattedDate" value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
	
	<p> 현재 시간 : ${formattedDate}</p>
	
	<c:set var="price" value="12345.678"/>
	<fmt:formatNumber value="${price}" type="currency" var="formatPrice"/>
	<p>Format Price : ${formatPrice} </p>
	
</body>                                                                                                                                  
</html>