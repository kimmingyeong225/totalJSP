<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
	<h1>계산 결과</h1>
	
	<!-- html 주석입니다 -->
	<%-- JSP 주석 입니다 --%>
	<%
		// 폼에서 데이터 추출
		String num1= request.getParameter("num1");
		String num2= request.getParameter("num2");
		
		int num11 = Integer.parseInt(num1);
		int num22 = Integer.parseInt(num2);
		
		int number = num11 + num22;
		
		// 방어적 코드 작성
		if(num1 == null || num1.trim().isEmpty() || num2 == null || num2.trim().isEmpty()) {
			out.println("앗!!!! 값을 입력해주세요!!");
		} else {
			out.println("<p>" + num1 + " 와 " + num2 + " 의 " + "결과 값은 " + number +  "입니다");
		}
		
		// 계산에 결과를 스트림을 통해 내려주기
	%>
	
	<a href="calculator_form.html">돌아가기</a>
</body>
</html>