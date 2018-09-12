<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("id", "cool");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	기본객체 사용 : <br>
	요청 URI : ${pageContext.request.requestURI}
	
	<hr>
	
	request 속성 확인 id : ${requestScope.id} 
	
	<hr>
	
	파라미터 확인 code : ${param.code}

















</body>
</html>