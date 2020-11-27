<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
1. id파라미터 조회
2. login정보 조회
	-로그아웃: "로그인 하세요"출력. loginForm.me페이지로 이동.
3. 내정보가 아니면서 , admin도 아닌경우
	-내정보만 수정가능합니다. 출력. main.me 페이지 이동
4. id 정보를 db에서 읽어 Member객체에 저장
5. Member 객체를 화면에 출력 
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정하기</title>
<script type="text/javascript">
function inputcheck(f) {
	if(f.pass.value==""){
		alert("비밀번호를 입력하세요");
		f.pass.focus();
		return false;
	}
}
function win_passchg() {
	let op="width=500, height=400, left=50, top=150";
	open("passwordForm.me","",op);
}
function win_upload() {
	let op="width=500, height=400, left=50, top=150";
	open("pictureForm.me","",op);
}
</script>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<form action="update.me" name="f" method="post" onsubmit="return inputcheck(this)">
<input type="hidden" name="picture" value="${mem.picture }">
<table><caption>회원정보 수정</caption>
<tr><td rowspan="4" valign="bottom"><img src="picture/${mem.picture }" width="100" height="120" id="pic"><br><font size="1"><a href="javascript:win_upload()">사진수정</a></font>
<tr><th>아이디</th><td><input type="text" name="id" readonly value="${mem.id }"></td></tr> <!-- 수정불가 readonly -->
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><th>이름</th><td><input type="text" name="name" value="${mem.name }"></td></tr>
<tr><th>성별</th><td colspan="2"><input type="radio" name="gender" value="1" ${mem.gender==1?"checked":""}>남
<input type="radio" name="gender" value="2" ${mem.gender==2?"checked":""}>여</td></tr>
<tr><th>전화번호</th><td colspan="2"><input type="text" name="tel" value="${mem.tel }"></td></tr>
<tr><th>이메일</th><td colspan="2"><input type="text" name="email" value="${mem.email }"></td></tr>

<tr><td colspan="3"><input type="submit" value="회원수정">
<c:if test="${param.id =='admin' || sessionScope.login !='admin' }">
<input type="button" value="비밀번호 수정" onclick="win_passchg()">
</c:if>
</td></tr>
</table>
</form>
</body>
</html>