<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인화면</title>
<link rel="stylesheet" href="../../css/main.css">
<script type="text/javascript">
	function inputcheck(f) {
		if (f.id.value == "") {
			alert("id를 입력하게요");
			f.id.focus();
			return false;
		}
		if (f.id.value.length < 4) {
			alert("id는 4자리 이상 입력하세요");
			f.id.focus();
			return false;
		}
		if (f.pass.value == "") {
			alert("비밀번호를 입력하게요");
			f.pass.focus();
			return false;
		}
		return true;
	}
	function win_open(page) {
		let op = "width=500, height=350, left=50, top=150";
		open(page + ".me", "", op);
	}
</script>
</head>
<body>
	<form name="f" action="login.me" method="post"
		onsubmit="return inputcheck(this)">
		<table>
			<caption>로그인</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"> <input
					type="button" value="회원가입" onclick="location.href='joinForm.me'">
					<input type="button" value="아이디 찾기" onclick="win_open('idForm')">
					<input type="button" value="비밀번호 찾기" onclick="win_open('pwForm')">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>