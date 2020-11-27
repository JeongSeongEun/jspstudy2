<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원사진 등록</title>
<link rel="stylesheet" href="../../css/main.css">
</head>
<body>
<h3>사진업로드</h3>
<table>
<tr><td><img id="preview" src=""></td></tr>
<tr><td>
<form action="picture.me" method="post" enctype="multipart/form-data">
<input type="file" name="picture" id="imageFile" accept="img/*">
<input type="submit" value="사진등록">
</form>
</td></tr>
</table>
<script type="text/javascript">
var imagefile=document.querySelector('#imageFile');
var preview = document.querySelector('#preview');
//addEventListener: 이벤트의 등록
imagefile.addEventListener('change', function(e) {
	var get_file=e.target.files; //선택된 이미지 파일
	var reader=new FileReader(); //파일 선택
	reader.onload=(function (Img) {
		return function (e) {
			Img.src=e.target.result;
		}
	})(preview);
	if(get_file){
		reader.readAsDataURL(get_file[0]);
	}
});
</script>
</body>
</html>