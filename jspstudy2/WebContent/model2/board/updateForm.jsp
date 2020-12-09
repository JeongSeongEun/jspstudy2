<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
1. num값에 해당하는 게시물을 조회
2. 조회된 게시물을 화면에 출력
--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 수정 화면</title>
<link rel="stylesheet" href="../../css/main.css">
<script>
function file_delete() {
	document.f.file2.value="";
	file_desc.style.display="none";
}
</script>
</head>
<body>
<form action="update.do" method="post" enctype="multipart/form-data" name="f">
<input type="hidden" name="num" value="${b.num }">
<input type="hidden" name="file2" value="${b.file1 }">
<table class="w3-table-all"><caption>게시판 수정 화면</caption>
<tr><th>글쓴이</th><td><input type="text" name="name" value="${b.name }"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><th>제목</th><td><input type="text" name="subject" value="${b.subject }"></td></tr>
<tr><th>내용</th><td><textarea rows="15" name="content" id="content1">${b.content }</textarea></td></tr>
<script>CKEDITOR.replace("content1",{filebrowserImageUploadUrl:"imgupload.do"})</script>
<tr><th>첨부파일</th><td style="text-align: left">
<c:if test="${!empty b.file1 }">
<div id="file_desc">${b.file1}
<a href="javascript:file_delete()">[첨부파일 삭제]</a></div>
</c:if>
<input type="file" name="file1"></td></tr>
<tr><td colspan="2">
<a href="javascript:document.f.submit()">[게시물 수정]</a></td></tr>
</table>
</form>
</body>
</html>