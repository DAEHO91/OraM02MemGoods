<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />


</head>
<body>
<%@ include file ="/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>

<form action="<%= request.getContextPath() %>/Gin/g_insert_pro.goods" method="post">
<table border="1">
<tr>
	<td>상품명</td>
	<td><input type="text" name="g_name" size="20"></td>
<tr>
<tr>
	<td>분류</td>
	<td>
		<select name="g_cate">
			<option value="op1">가전</option>
			<option value="op2">전자</option>
			<option value="op3">식품</option>
			<option value="op4">의류</option>
		</select>
	</td>
<tr>
<tr>
	<td>상세</td>
	<td><input type="text" name="g_sangse" size="20"></td>
<tr>
<tr>
	<td>가격</td>
	<td><input type="text" name="g_price" size="20"></td>
<tr>
<tr>
	<input type="hidden" name="g_id" value=<%= S_ID %>>
	<td colspan="4"><input type="submit" value="상품등록"></td>
</tr>
</table>
</form>
	<%@ include file="/module/hadan.jsp" %>
</body>
</html>