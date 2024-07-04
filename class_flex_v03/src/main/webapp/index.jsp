<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.container {
		display: flex;
		flex-wrap: wrap;
		border: 2px solid #333;
		padding: 10px;
		background-color: #f9f9f9;
	}
	
	.item {
		 /*width: calc(33.333% - 10px); */
		background-color:  brown;
		color: white;
		margin: 5px;
		padding: 20px;
		text-align: center;
		border-radius: 5px;
	}
	
	.order-1 {
		order: 1;
	}
	
	.order-2 {
		order: 2;
	}
	
	/* 지정하지 않으면 더 우선 순위를 가진다 */
	.order-3 {
		order: 3;
	}
	/* flex-grow 속성은 특정 아이템 더 많은 공간을 차지해야 할 때 사용 */
	.grow-1 {
		flex-grow: 1;
		
	}
	
	/* flex-shrink 속성은 (공간이 부족할 때 얼마나 줄어들지를 결정)
		특정 아이템이 줄어들면서 다른 아이템과 균형을 맞추어야 할 때 활용한다.
	 */
	.shrink-1 {
		flex-shrink: 1;
		
	}
	
	.basis-100 {
		flex-basis: 300px;
		
	}
	
	/* flex(단축 속성) - flex-grow, flex-shrink, flex-basis를 한번에 설정하는 속성이다*/
	.foex-combined {
		flex: 1 1 300px;
	} 
</style>
</head>
<body>
	<%-- 
		http://localhost:8080/flex/index.jsp
		http://localhost:8080/flex
		width: calc(33.333% - 10px);
	 --%>
	<h2>order 속성</h2>
	<div class="container">
		<div class="item order-2">아이템1</div>
		<div class="item order-1">아이템2</div>
		<div class="item order-3">아이템3</div>
	</div>
	
	<h2>flex-grow 속성</h2>
	<div class="container">
		<div class="item grow-1">아이템1</div>
		<div class="item ">아이템2</div>
		<div class="item ">아이템3</div>
	</div>
	
	<h2>flex-shrink 속성</h2>
	<div class="container" style="width: 550px;">
		<div class="item shrink-1">아이템1(fles-shrink : 1)</div>
		<div class="item ">아이템2(fles-shrink : 0)</div>
		<div class="item ">아이템3(fles-shrink : 0)</div>
	</div>
	
	<h2>flex-basis 속성</h2>
	<div class="container">
		<div class="item basis-100">아이템1(fles-basis: 100px)</div>
		<div class="item ">아이템2</div>
		<div class="item ">아이템3</div>
	</div>
	
	<h2>flex 단축 속성</h2>
	<div class="container">
		<div class="item foex-combined">아이템1</div>
		<div class="item foex-combined">아이템2</div>
		<div class="item foex-combined">아이템3</div>
	</div>
</body>
</html>