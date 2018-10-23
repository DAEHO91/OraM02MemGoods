<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Goods" %>
<%@ page import = "java.util.ArrayList" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />


</head>
<body>
<%@ include file = "/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>
<b>상품 리스트</b> <br>
<!-- 
상품검색
	<form action="<%=request.getContextPath() %>/Gsearch/g_search_pro.ksmart" method = "post">
		<select name="key">
			<option value="#">준비중</option>
		</select>
		<input type="text" name="word">
		<button type="submit">검색</button>
	</form>
<br>
 -->
<table width="100%" border="1">
<tr>
	<td>상품코드</td><td>상품명</td><td>판매자아이디</td><td>분류</td><td>상세</td><td>가격</td><td>등록일</td><td>수정</td><td>삭제</td>
</tr>
<%
ArrayList<Goods> get_alm = (ArrayList<Goods>)request.getAttribute("glist");
for(int i=0; i<get_alm.size(); i++) {
	Goods g = get_alm.get(i);
%>
	<tr>
		<td><%= g.getG_code() %></td>
		<td><%= g.getG_name() %></td>
		<td><%= g.getG_id() %></td>
		<td><%= g.getG_cate() %></td>
		<td><%= g.getG_sangse() %></td>
		<td><%= g.getG_price() %></td>
		<td><%= g.getG_date() %></td>
	<%if(session.getAttribute("S_ID").equals(g.getG_id())) { %>
		<td><a href="<%=request.getContextPath()%>/Gup/g_update_form.goods?send_code=<%= g.getG_code() %>">수정</a></td>
		<td><a href="<%=request.getContextPath()%>/Gdel/g_delete_form.goods?send_code=<%= g.getG_code() %>">삭제</a></td>
	<%} else { %>
		<td>권한없음</td>
		<td>권한없음</td>
	<%} %>
		
	</tr>
<%
}
%>
</table>

	<%@ include file="/module/hadan.jsp" %>
</body>
</html>