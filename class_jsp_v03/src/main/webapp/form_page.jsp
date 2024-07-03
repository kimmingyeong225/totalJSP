<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ include file="header.jsp" %>

<style >


	
	.b {
		    display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            background-color: #f0f0f0;
            height: 100vh;
	}
	


</style>



	
	<div class="b">
	<form action="revlet.jsp" method="POST">
		<h1>cm를 인치로 변환</h1>
	<label for="number" >cm</label>
	<input type="number" id="number" name="number">
	
	<button type="submit">반환</button>
	
	</form>
	</div>
	<%@ include file="footer.jsp" %>

