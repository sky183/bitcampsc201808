<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.MemberInfo" %>
<%
	MemberInfo mem = (MemberInfo) session.getAttribute("MemberInfo");
	boolean login = mem == null ? true : false;
	if (login) {
		%>
	<script>
		alert('로그인 후 사용가능한 서비스입니다.');
		location.href = 'loginForm.jsp';
	</script>	
		
		<%
	} else {
%>
