<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL을 이용한 간단한 연산</title>
</head>
<body>
<form name="f" method="post">
x: <input type="text" name="num1" value="${param.num1}">
    <select name="op" value="${param.op}">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
y: <input type="text" name="num2" value="${param.num2}">
    <input type="submit" value="=">
    <br><br>
    <fmt:formatNumber var="result" value="${0}"/>
    <c:choose>
        <c:when test="${param.op.equals('+')}">
            <fmt:parseNumber value="${param.num1 + param.num2}" var="result"/>
        </c:when>
        <c:when test="${param.op.equals('-')}">
            <fmt:parseNumber value="${param.num1 - param.num2}" var="result"/>
        </c:when>
        <c:when test="${param.op.equals('*')}">
            <fmt:parseNumber value="${param.num1 * param.num2}" var="result"/>
        </c:when>
        <c:otherwise>
            <fmt:parseNumber value="${param.num1 / param.num2}" var="result"/>
        </c:otherwise>
    </c:choose>
    <h3>${param.num1} ${param.op} ${param.num2} = ${result}</h3>
</form>
</body>
</html>
