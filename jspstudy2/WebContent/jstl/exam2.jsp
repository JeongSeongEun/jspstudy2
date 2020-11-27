<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력된 수 까지의 합 구하기</title>
</head>
<body>
<form method="post">
숫자: <input type="text" name="num" value="${param.num }">
<input type="submit" value="숫자까지의 합 구하기">
</form>
<c:forEach var="i" begin="1" end="${param.num }">
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>
합계:<c:out value="${sum }"/>

<h3>if태그를 이용하여 짝수 홀수 출력하기</h3>
<c:if test="${sum%2==0 }">${sum }은 짝수입니다.<br></c:if>
<c:if test="${sum%2==1 }">${sum }은 홀수입니다.<br></c:if>

<h3>choose when태그를 이용하여 짝수 홀수 출력하기</h3>
<c:choose>
	<c:when test="${sum%2==0 }">${sum }은 짝수입니다.<br></c:when>
	<c:otherwise>${sum }은 홀수입니다.<br></c:otherwise>
</c:choose>
</body>
</html>