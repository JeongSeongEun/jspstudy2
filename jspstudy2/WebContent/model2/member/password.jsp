<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
1. 로그아웃상태인 경우. 로그인하세요. 메세지 출력.
	다른사용자의 비밀번호 변경 불가. => 로그인된 id 값만 변경 가능. 본인만 변경가능
	opener 페이지를 loginForm.jsp페이지 이동.
	현재페이지 닫기
2. pass, chgpass파라미터 값 저장
3. pass 비밀번호가 db에 저장된 비밀번호와 다르면 비밀번호 오류 메시지 출력. passwordForm.jsp 페이지 이동
4. pass 비밀번호가 db에 저장된 비밀번호와 같으면 MemberDao.updatePass(login,chgpass) =>새로운 비밀번호로 수정
	비밀번호수정.
	opener 페이지를 updateForm.jsp페이지 이동
	현재페이지 닫기
 --%>
<script>
 alert("${msg}");
 <c:if test="${opener}"> 
 opener.location.href="${url}";
 </c:if>
 <c:if test="${!opener}"> 
 location.href="${url}";
 </c:if>
 <c:if test="${closer}">
 self.close();
</c:if>
 </script>