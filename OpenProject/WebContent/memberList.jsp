<%@page import="java.util.ArrayList"%>
<%@page import="member.model.MemberInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="loginInfo" class="member.model.LoginInfo" scope="session" />	
	
<%
	//String id = (String)request.getSession(false).getAttribute("userId");
	//String name = (String)request.getSession(false).getAttribute("userName");
	
	System.out.println(loginInfo);

	if (loginInfo.getUserId() == null){
		%>
		
	<script>
		alert('로그인 후 사용가능한 서비스입니다.');
		location.href = 'loginForm.jsp';
	</script>	
		
		<%
	} 
%>
<%
	List<MemberInfo> members = null;

	if(application.getAttribute("members") != null){
		members = (List<MemberInfo>)application.getAttribute("members");			
	} else {
		members = new ArrayList<MemberInfo>();
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
	h2 {
		padding : 10px;
	}
	
	table {
		margin-top: 10px;
	}
	td {		
		padding: 10px 20px;
	}
</style>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="contents">
<h2>회원리스트</h2>
    
    <hr>
    
        <table border="1">
            <tr>
                <td>아이디</td>
                <td>비밀번호</td>
                <td>이름</td>
                <td>사진</td>
                <td>관리</td>
            </tr> 
            <%            
            for(int i=0; i < members.size() ; i++){
        		MemberInfo member = members.get(i);
        		%>        		
        	<tr>
                <td><%= member.getUserId()%></td>
                <td><%= member.getPassword()%></td>
                <td><%= member.getUserName()%></td>
                <td><%= member.getUserPhoto()%></td>
                <td>수정 삭제</td>
            </tr>
        		<%
        	}
            
            
            %>         
        </table>
    
    
</div>





</body>
</html>