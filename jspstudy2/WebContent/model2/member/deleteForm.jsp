<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>회원탈퇴 비밀번호 입력</title>
    <link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<form action="delete.me" name="f" method="post" onsubmit="return inputcheck(this)">
    <input type="hidden" name="id" value="${param.id }">
    <table>
        <caption>회원비밀번호 입력</caption>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="탈퇴하기"></td>
        </tr>
    </table>
</form>
</body>
</html>
