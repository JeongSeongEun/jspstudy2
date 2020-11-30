<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 삭제</title>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<form action="delete.do" name="f" method="post">
<input type="hidden" name="num" value="${param.num}">
<table><caption>게시글 삭제 화면</caption>
<tr>
<td>게시글 비밀번호</td>
<td><input type="password" name="pass"></td>
</tr>
<tr><td colspan="2"><input type="submit" value="게시글 삭제"></td></tr>
</table>
</form>
</body>
</html>