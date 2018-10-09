<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="loginInfo" class="member.model.LoginInfo" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
h2, td {
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="common/header.jsp"%>


	<div id="contents">

		<h2>회원가입</h2>

		<hr>
		<form action="memberAction" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="userId" value></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="userPhoto"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left: 10px; color: red;" id="error">
						<%
							String error = (String) request.getAttribute("error");
							if (error != null) {
						%>
						<b><%=error%></b>
						<%
							} else {
						%>
						<b>&nbsp</b>
						<%
							}
						%>
					</div>
				</tr>

			</table>

		</form>



	</div>











</body>
</html>