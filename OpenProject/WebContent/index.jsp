<%@page import="java.util.ArrayList"%>
<%@page import="member.model.MemberInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="loginInfo" class="member.model.LoginInfo" scope="session" />

<%	
	//회원정보를 받아올 members 객체를 생성
	List<MemberInfo> members = null;
	
	//어플리케이션 객체의 members 속성의 값이 null이 아닐 경우 members 속성의 값을 List로 형변환하여 members에 담는다.
	if(application.getAttribute("members") != null){
		members = (List<MemberInfo>)application.getAttribute("members");			
	} else {
		
		//members 속성의 값이 null일 경우 새 ArrayList를 만든다.
		members = new ArrayList<MemberInfo>();
	}
	
	//리스트의 용량만큼 가져와서 콘솔에 뿌려준다.
	for(int i=0; i < members.size() ; i++){ 
		System.out.println(members.get(i));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
</head>
<body>

<%@ include file="common/header.jsp" %>
<h1>메인 화면입니다.</h1>
</body>
</html>