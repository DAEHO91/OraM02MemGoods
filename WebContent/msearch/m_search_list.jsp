<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "java.util.ArrayList" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />


</head>
<body>
<%@ include file = "/module/top.jsp" %>
<%@ include file="/module/left.jsp" %>
<b>검색 결과 리스트</b> <br>
회원검색 
	<form action="<%=request.getContextPath() %>/Msearch/m_search_pro.ksmart" method = "post">
		<select name="key">
			<option value="ora_id">ID</option>
			<option value="ora_pw">PW</option>
			<option value="ora_level">LEVEL</option>
			<option value="ora_name">NAME</option>
			<option value="ora_email">EMAIL</option>
		</select>
		<input type="text" name="word">
		<button type="submit">검색</button>
	</form>
<br>
<table width="100%" border="1">
<tr>
	<td>아이디</td><td>비번</td><td>권한</td><td>이름</td><td>이메일</td><td>수정</td><td>삭제</td>
</tr>
<%
ArrayList<Member> get_alm = (ArrayList<Member>)request.getAttribute("mSearchList");
for(int i=0; i<get_alm.size(); i++) {
	Member m = get_alm.get(i);
%>
	<tr>
		<td><%= m.getOra_id() %></td>
		<td><%= m.getOra_pw() %></td>
		<td><%= m.getOra_level() %></td>
		<td><%= m.getOra_name() %></td>
		<td><%= m.getOra_email() %></td>
		<td><a href="<%=request.getContextPath()%>/Mup/m_update_form.ksmart?send_id=<%= m.getOra_id() %>">수정</a></td>
		<td><a href="<%=request.getContextPath()%>/Mdel/m_delete_pro.ksmart?send_id=<%= m.getOra_id() %>">삭제</a></td>
	</tr>
<%
}
%>
</table>
	<%@ include file="/module/hadan.jsp" %>
</body>
</html>