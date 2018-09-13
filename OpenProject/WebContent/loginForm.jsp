<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="loginInfo" class="member.model.LoginInfo" scope="session" />

<%
   String id = "";
   String chk = "";
   //저장된 쿠키를 불러옴
   Cookie[] cookies = request.getCookies();
   //만약 쿠키가 저장되어 있으면
   if(cookies !=null && cookies.length > 0){
      for(int i = 0; i < cookies.length; i++){
         if(cookies[i].getName().equals("id")){
            id = cookies[i].getValue();
            chk = "checked";
         }
      }
   }
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
	h2, td {
		padding : 10px;
	}
</style>
</head>
<body>

<%@ include file="common/header.jsp" %>


<div id="contents">
<h2>로그인</h2>
    
    <hr>
    <form action="login.jsp" method="post">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="userId" value=<%=id %>></td>
            </tr>  
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="로그인"></td>
                <td><input type="checkbox" name="chk" <%=chk %>>아이디 기억</td>
            </tr>          
        </table>
    
    </form>
    
</div>











</body>
</html>