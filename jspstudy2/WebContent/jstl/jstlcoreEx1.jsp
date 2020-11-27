<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL core 태그</title>
</head>
<body>
<h3>속성 관련 태그: set, remove, out태그</h3>
<%//session.setAttribute("test", "Hello JSTL"); %>
<c:set var="test" value="${'Hello JSTL' }" scope="session"/>
test 속성: ${sessionScope.test }<br>
test 속성: <c:out value="${test }"/><br>
test 속성: ${test }<br>
<c:remove var="test"/>
test 속성: ${test }<br>
</body>
</html>