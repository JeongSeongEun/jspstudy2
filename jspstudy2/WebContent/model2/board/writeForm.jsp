<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="../../css/main.css">
<script type="text/javascript">
	function inputcheck() {
		f = document.f;
		if (f.name.value == "") {
			alert("글쓴이를 입력하세요");
			f.name.focus();
			return;
		}
		if (f.pass.value == "") {
			alert("비밀번호를 입력하세요");
			f.pass.focus();
			return;
		}
		if (f.subject.value == "") {
			alert("제목을 입력하세요");
			f.subject.focus();
			return;
		}
		if (f.content.value == "") {
			alert("내용을 입력하세요");
			f.content.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<form action="write.do" method="post" enctype="multipart/form-data"
		name="f">
		<table>
			<caption>게시판 글쓰기</caption>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="15" name="content"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td colspan="2"><a href="javascript:inputcheck()">[게시물 등록]</a></td>
			</tr>
		</table>
	</form>
</body>
</html>