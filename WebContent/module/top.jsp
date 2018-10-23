<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String S_ID = (String)session.getAttribute("S_ID");
	String S_NAME = (String)session.getAttribute("S_NAME");
	String S_LEVEL = (String)session.getAttribute("S_LEVEL");
	System.out.println(S_LEVEL+"<-----------session LEVEL값!");
%>

<!-- Begin Wrapper -->
   <div id="wrapper">
         <!-- Begin Header -->
         <div id="header">
/module/top.jsp <br>
		상단 메뉴	<br><br>	 
<% if(S_ID==null){ %>
<!-- 로그인 전 화면 시작 -->
		<a href="<%=request.getContextPath()%>/Min/m_insert_form.ksmart">회원추가</a><br><br>
		<form action ="<%=request.getContextPath() %>/Mlogin/m_login_pro.ksmart" method = "post">
			<input type="text" name = "id">
			<input type="password" name = "pw">
			<button type="submit" id = "login">로그인</button>
		</form>
<!-- 로그인 전 화면 End -->			
<%}else{ %>
	<%	if(S_LEVEL.equals("관리자")){ %>
			<a href="<%=request.getContextPath()%>/Min/m_insert_form.ksmart">회원추가</a>
			<a href="<%=request.getContextPath()%>/Mlist/m_list.ksmart">회원검색</a>
			<a href="<%=request.getContextPath()%>/Gin/g_insert_form.goods">상품등록</a>
			<a href="<%=request.getContextPath()%>/Gin/g_list.goods">상품목록</a>
	
	<%	}else if(S_LEVEL.equals("사용자")){ %>
			<a href="<%=request.getContextPath()%>/Min/m_insert_form.ksmart">회원추가</a>
			<a href="<%=request.getContextPath()%>/Glist/g_list.goods">상품목록</a>
	<%	} %>
		<br><br>
		<%= S_NAME %> 님 <%= S_LEVEL %> 권한 로그인 중
		<a href ="<%=request.getContextPath()%>/MLogin/m_logout_pro.ksmart">로그아웃</a>
<%} %>			
		 </div>
		 <!-- End Header -->
		 