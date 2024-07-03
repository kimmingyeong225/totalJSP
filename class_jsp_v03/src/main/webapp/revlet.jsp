<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>



<style >

	.t {
			display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            background-color: #f0f0f0;
            height: 400px;
	
	}

	


</style>
<div class="t">

<form>
	<h1>반환 결과</h1>
	<%
		String number =  request.getParameter("number");
		int numm = Integer.parseInt(number);

		
		
		double sum = 2.54;
		double num =  numm / sum;
		
		String re = String.format("%.2f", num);
		
	

		if(number == null ) {
			out.println("<p> 숫자를 입력해주세요</p>");
		} else {
			
		}
	%>
	<label for="number" ><%=number %>  cm의 <%=re %> 입니다.</label>
</form>
</div>

<%@ include file="footer.jsp" %>