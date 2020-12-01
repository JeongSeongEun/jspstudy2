<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>id찾기</title>
    <link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<table>
    <tr>
        <th>아이디</th>
        <td>${id}**</td>
    </tr>
    <tr>
        <td colspan="2"><input type="button" value="아이디 전송" onclick="idsend('${id}**')"></td>
    </tr>
</table>
<script>
    function idsend(id) {
        opener.document.f.id.value = id;
        self.close();
    }
</script>
</body>
