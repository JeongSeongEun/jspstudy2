<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일 보내기</title>
<script type="text/javascript">
function idinputchk(f) {
	if(f.naverid.value ==""){
		alert("네이버 아이디를 입력하세요");
		f.naverid.focus();
		return false;
	}
	if(f.naverpw.value ==""){
		alert("네이버 비밀번호를 입력하세요");
		f.naverpw.focus();
		return false;
	}
	return ture;
}
</script>
</head>
<body>
<h2>메일보내기</h2>
<form name="mailform" method="post" action="mail.me" onsubmit="return idinputchk(this)">
본인네이버ID: <input type="text" name="naverid">
본인네이버PW: <input type="password" name="naverpw">
		<table class="w3-table-all">
			<tr>
				<td>받는사람</td>
				<td><input type="text" name="recipient" size="100"
					value='<c:forEach items="${list}" var="mail">${mail},</c:forEach>'></td>
			<tr>
				<td>메시지형식</td>
				<td><select name="mtype">
						<option value="text/html; charset=UTF-8">HTML</option>
						<option value="text/html; charset=UTF-8">TEXT</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="contents" rows="10" cols="120"></textarea>
				</td>
			</tr>
			<tr>
				<td  class="w3-center" colspan="2"><input type="submit" value="메일보내기"></td>
			</tr>
		</table>
	</form>
</body>
</html>