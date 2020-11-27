<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL(표현언어) 예제</title>
</head>
<body>
<%
session.setAttribute("test", "session test 속성");
session.setAttribute("today", new Date());
%>
<form action="elEx2.jsp" method="post">
이름: <input type="text" name="name" value="정성은">
<input type="submit" value="전송">
</form>
</body>
</html>