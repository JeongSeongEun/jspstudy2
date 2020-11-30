<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<table>
<caption>게시글 상세보기</caption>
 <tr>
        <th width="20%">글쓴이</th>
        <td style="text-align: left">${b.name }</td>
    </tr>
    <tr>
        <th width="20%">제목</th>
        <td style="text-align: left">${b.subject }</td>
    </tr>
    <tr>
        <th width="20%">내용</th>
        <td style="text-align: left; vertical-align: text-top; height: 200px;">${b.content}</td>
    </tr>
    <tr>
        <th>첨부파일</th>
        <td>
        <c:if test="${empty b.file1 }">&nbsp;</c:if>
        <c:if test="${!empty b.file1 }">
        <a href="./file/${b.file1 }">${b.file1 }</a>
        </c:if>
       </td>
    </tr>
    <tr>
        <td colspan="2">
            <a href="replyForm.do?num=${b.num }">[답변]</a>
            <a href="updateForm.do?num=${b.num }">[수정]</a>
            <a href="deleteForm.do?num=${b.num }">[삭제]</a>
            <a href="list.do">[목록]</a>
        </td>
    </tr>
</table>
</body>
</html>
