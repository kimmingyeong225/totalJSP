<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/list.css">
</head>
<body>
	<h2>게시글 목록</h2>
	<div class="action">
		<a href="${pageContext.request.contextPath}/board/create" >새글 작성하기</a>
		<a href="${pageContext.request.contextPath}/index.jsp" >홈 화면</a>
	</div>
	
	<c:forEach var="board"  items="${boardList}">
		<div class="board-item">
			<h3><a href="#">${board.title}</a></h3>
			<p>${board.content}</p>
			<p><f:formatDate value="${board.createdAt}" pattern="yy-MM-dd HH:MM"/></p>
			<!-- 게시글에 작성자가 세션 유저와 동일하다면 수정, 삭제 버튼을 보여주자  -->
			<c:if test="${board.userId == userId}">
			<a class="btn btn-edit" href="#">수정</a>
			<a class="btn btn-delete" href="#">삭제</a>
			</c:if>
			
		</div>
	</c:forEach>
	
	<br>
	<div class="pagination">
		<!-- index for  -->
		<c:forEach begin="1" end="${totalPages}"  var="i" >
			<c:choose>
				<c:when test="${i == currentPate }">
				<span class="current-page">${i}</span>
				</c:when>
				<c:otherwise>
			<span><a href="${pageContext.request.contextPath}/board/list?page=${i}">${i}</a></span>
				</c:otherwise>
			</c:choose>
		</c:forEach>
				
	</div>
	
</body>
</html>


