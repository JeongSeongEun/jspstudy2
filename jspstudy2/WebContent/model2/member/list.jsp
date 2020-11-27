<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
1. 로그아웃 상태: 로그인이 필요합니다. loginForm.jsp페이지 이동
2. 로그인 상태: 
	일반사용자: 관리자만 가능합니다. main.jsp 페이지 이동
3. 관리자 로그인 상태
	db에서 모든 회원 정보를 조회하여 List<Member>객체로 리턴
4. List 객체를 화면에 출력하기 
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
	<table>
		<caption>회원 목록</caption>
		<tr>
			<th>아이디</th>
			<th>사진</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach var="m" items="${list}">
		<tr>
			<td><a href="info.jsp?id=${ m.id}">${m.id }</a></td>
			<td><img src="picture/sm_${m.picture }" width="20"
				height="30"></td>
			<td>${m.name }</td>
			<td>${m.gender==1?"남":"여" }</td>
			<td>${m.tel }</td>
			<td><a href="updateForm.me?id=${m.id }">[수정]</a> 
 	<c:if test="${m.id != 'admin'}">
 <a href="deleteForm.me?id=${m.id }">[강제탈퇴]</a>
 </c:if>
 	</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>