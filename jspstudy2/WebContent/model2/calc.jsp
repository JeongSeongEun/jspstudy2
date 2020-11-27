<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>모델2 연습</title>
</head>
<body>
<form action="calc.me" method="post">
<input type="text" name="num1" value="${param.num1}" size="5">
<select name="op">
<option>+</option>
<option>-</option>
<option>*</option>
<option>/</option>
</select>
<script type="text/javascript">
var op='${param.op}';
if(op=='')op="+"
document.forms[0].op.value=op;
</script>
<input type="text" name="num2" value="${param.num2}" size="5">
<input type="submit" value="=">
<input type="text" name="result" value="${result}" size="5">
</form>
</body>
</html>