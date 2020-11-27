<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL에서 연산자 사용하기</title>
</head>
<body>
<h3>\${5 + 7} = ${5+7}</h3>
<h3>\${8 - 3} = ${8 - 3}</h3>
<h3>\${8 / 3} = ${8 / 3}</h3>
<%-- <h3>\${8 div 3} = ${8 div 3}</h3> --%>
<h3>\${8 % 3} = ${8 % 3}</h3>
<h3>\${8 mod 3} = ${8 mod 3}</h3>
<h3>\${10 == 9} = ${10 == 9}</h3>
<h3>\${10 eq 9} = ${10 eq 9}</h3>
<h3>\${10 != 9} = ${10 != 9}</h3>
<%-- <h3>\${10 ne 9} = ${10 ne 9}</h3> --%>
<h3>\${10 >= 9} = ${10 >= 9}</h3>
<h3>\${10 ge 9} = ${10 ge 9}</h3>
<h3>\${10 < 9} = ${10 < 9}</h3>
<h3>\${10 lt 9} = ${10 lt 9}</h3>
<h3>\${10 > 9} = ${10 > 9}</h3>
<h3>\${10 gt 9} = ${10 gt 9}</h3>
<h3>\${5+4==8?8:10} = ${5+4==8?8:10}</h3>
<h3>\${test} = ${test}</h3>
<h3>\${'test'} = ${'test'}</h3>
<h3>\${"EL의 상수표현"} = ${"EL의 상수표현"}</h3>


</body>
</html>