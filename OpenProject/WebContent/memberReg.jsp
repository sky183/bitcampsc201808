<%@page import="java.util.ArrayList"%>
<%@page import="member.model.MemberInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


<%
   List<MemberInfo> members = new ArrayList<MemberInfo>();;

   if (application.getAttribute("members") != null) 
      members = (List<MemberInfo>) application.getAttribute("members");
%>
<%
   request.setCharacterEncoding("utf-8");

   String userId = request.getParameter("userId");
   String password = request.getParameter("password");
   String userName = request.getParameter("userName");
   boolean equal = false;

   for (int i = 0; i < members.size(); i++) {
      if (members.get(i).getUserId().equals(userId)) {
         equal = true;
      }
   }

   if (equal) {
%>
<script>
         alert('이미 가입된 아이디입니다.');
         location.href = 'memberRegForm.jsp'; 
</script>
<%
   } else {
      MemberInfo memberInfo = new MemberInfo();
      memberInfo.setUserId(userId);
      memberInfo.setUserName(userName);
      memberInfo.setPassword(password);

      members.add(memberInfo);
      application.setAttribute("members", members);
%>
<jsp:useBean id="loginInfo" class="member.model.LoginInfo"
   scope="session" />
<jsp:setProperty property="userId" name="loginInfo"
   value="<%=memberInfo.getUserId()%>" />
<jsp:setProperty property="userName" name="loginInfo"
   value="<%=memberInfo.getUserName()%>" />
<jsp:setProperty property="userPhoto" name="loginInfo"
   value="<%=memberInfo.getUserPhoto()%>" />

<%
   response.sendRedirect("myPage.jsp");
   }
%>