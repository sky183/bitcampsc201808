<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>원하시는 페이지를 선택해 주세요.</h3>

<!-- request.getContextPath() : /web20180907 -->
<form action="<%= request.getContextPath() %>/view.jsp" method="post">
	<select name="code">
		<option value="A">A</option>
		<option value="B">B</option>
		<option value="C">C</option>
	</select>
	<input type="submit" value="페이지 보기">

</form>




</body>
</html>






