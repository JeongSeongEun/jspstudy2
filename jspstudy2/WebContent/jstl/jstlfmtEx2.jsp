<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>형식관련 태그 예제2</title>
</head>
<body>
<h3>Formate된 숫자를 일반 숫자로 변경</h3>
<fmt:parseNumber value="20,000" var="num1" pattern="##,###"/>
<fmt:parseNumber value="10,000" var="num2" pattern="##,###"/>
합: ${num1}+${num2}=${num1+num2}<br>
문제: 20,000+10,000 = 30,000출력하기<br>
<fmt:formatNumber value="${num1}" var="snum1" pattern="##,###"/>
<fmt:formatNumber value="${num2}" var="snum2" pattern="##,###"/>
<fmt:formatNumber value="${num1+num2}" var="snum3" pattern="##,###"/><br>
${snum1 }+${snum2 }=${snum3 }<br>
<h3>Format 된 날짜를 날짜형으로 변경</h3>
<fmt:parseDate value="2020-12-25 12:00:00" pattern="yyyy-MM-dd HH:mm:ss" var="day"/>
${day }<br>
문제: 2020-12-25 의 요일을 출력하기<br>
<fmt:formatDate value="${day }" pattern="yyyy-MM-dd E요일"/>
</body>
</html>