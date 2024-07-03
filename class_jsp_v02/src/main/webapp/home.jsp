<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
<%@ page import="java.util.Date" %>

<h1>JSP 지시자 예제</h1>
<p> 현재 시간 <%= new Date() %> </p>

<%@ include file="footer.jsp" %>
