<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 답글쓰기</title>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<form action="reply.do" method="post" name="f">
<input type="hidden" name="num" value="${b.num }">
<input type="hidden" name="grp" value="${b.grp }">
<input type="hidden" name="grplevel" value="${b.grplevel }">
<input type="hidden" name="grpstep" value="${b.grpstep }">
<table><caption>게시판 답글 등록</caption>
<tr><th>글쓴이</th><td><input type="text" name="name"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><th>제목</th><td><input type="text" name="subject" value="RE: ${b.subject }"></td></tr>
<tr><th>내용</th><td><textarea rows="15" name="content"></textarea></td></tr>
<tr><td colspan="2">
<a href= "javascript:document.f.submit()">[답변글등록]</a></td></tr>
</table>
</form>
</body>
</html>