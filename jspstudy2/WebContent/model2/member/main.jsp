<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
1. 로그인 여부 검증
로그인 상태: 현재화면
	로그인이 admin인경우 회원목록 보기 추가하기
로그아웃 상태: 로그인하세요. 메시지 출력후 loginForm.jsp로 페이지 이동
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
</head>
<body>
<h3>${sessionScope.login }로 로그인 되었습니다.</h3>
<h3><a href="logout.me">로그아웃</a></h3>
<h3><a href="info.me?id=${sessionScope.login }">회원정보보기</a></h3>
<c:if test="${sessionScope.login=='admin' }">
<h3><a href="list.me">회원목록보기</a></h3>
</c:if>
</body>
</html>