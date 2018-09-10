<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	<%
		Cookie[] cookies = request.getCookies();
	
		if( cookies != null && cookies.length > 0) {
			
			for ( int i=0 ; i < cookies.length ; i++){			
			%>
			
			<%= cookies[i].getName() %> = <%= cookies[i].getValue() %> <br>
			
			<%
			}
			
		} else {
	
	%>
	저장된 쿠키 정보가 없습니다.
	<%} %>
	
</h1>

	<a href="editCookie.jsp">쿠키 변경</a> <br>
	<a href="deleteCookie.jsp">id 쿠키 삭제</a>
</body>
</html>






