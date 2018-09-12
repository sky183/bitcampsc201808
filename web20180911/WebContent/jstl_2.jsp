<%@page import="test.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>날짜 포멧</h1>


<c:set var="now" value="<%= new java.util.Date() %>"/>

<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
<br>

<fmt:formatDate value="${now}" type="time" timeStyle="full" /><br>
<fmt:formatDate value="${now}" type="time" timeStyle="short" /><br>
<br>

<fmt:timeZone value="Hongkong">
<fmt:formatDate value="${now}" type="both" timeStyle="full" dateStyle="full" /><br>
</fmt:timeZone>
<br>

<fmt:formatDate value="${now}" pattern="z a h:mm" /><br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /><br>
<fmt:formatDate value="${now}" pattern="yyyy.MM.dd" /><br>
<fmt:formatDate value="${now}" pattern="yyyy/MM/dd. h:mm" /><br>





<hr>

<h1>숫자 포멧</h1>
<c:set var="price" value="100000"/>

<fmt:formatNumber value="${price}" type="number" var="numberType" scope="session"/>

${numberType}

<br>

통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="$" />

<br>

퍼센트 : <fmt:formatNumber value="${price/1000000}" type="percent" groupingUsed="false"/>

<br>

패턴 : <fmt:formatNumber value="${price}" pattern="0,000,000,000.00"/>















</body>
</html>