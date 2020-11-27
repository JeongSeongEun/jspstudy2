<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core 태그: 조건문 예제(if, choose)</title>
</head>
<body>
<h3>조건문 관련 태그: if, choose태그</h3>
<c:if test="${5<10 }">
<h4>5는 10보다 작다</h4>
</c:if>
<%if(5<10){ %>
<h4>5는 10보다 작다</h4>
<%} %>
<c:if test="${6+3 != 9 }">
<h4>6+3은 9가 아니다</h4>
</c:if>
<c:choose>
<c:when test="${ 5+10==25}">
<h4>5+10은 25다.</h4></c:when>

<c:when test="${ 5+10==15}">
<h4>5+10은 15다.</h4></c:when>
<c:otherwise>
<h4>5+10은 모른다.</h4></c:otherwise>
</c:choose>
</body>
</html>