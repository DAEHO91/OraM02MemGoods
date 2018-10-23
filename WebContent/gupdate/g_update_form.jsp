<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "kr.or.ksmart.dao.Gdao" %>
<%@ page import = "kr.or.ksmart.dto.Goods" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
</head>
<body>
<%@ include file = "/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>
<%
System.out.println("g_update_form!!<<<<<<<");
Goods g = (Goods)request.getAttribute("gUpdateForm");
System.out.println(g.getG_code()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<");
%>

	<form action="<%= request.getContextPath() %>/Gup/g_update_pro.goods" method="post">
		<table border="1">
			<tr>
				<td>상품코드</td>
				<td><input type="text" name="g_code" size="20" value="<%= g.getG_code() %>" readonly></td>
			<tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="g_name" size="20" value="<%= g.getG_name() %>"></td>
			<tr>
			<tr>
				<td>분류</td>
				<td><input type="text" name="g_cate" size="20" value="<%= g.getG_cate() %>"></td>
			<tr>
			<tr>
				<td>상세</td>
				<td><input type="text" name="g_sangse" size="20" value="<%= g.getG_sangse() %>"></td>
			<tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="g_price" size="20" value="<%= g.getG_price() %>"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="물품수정"></td>
			</tr>
		</table>
	</form>
<%@ include file="/module/hadan.jsp" %>
</body>
</html>