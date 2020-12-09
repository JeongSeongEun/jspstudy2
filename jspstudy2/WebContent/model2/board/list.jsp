<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록 보기</title>
<link rel="stylesheet" href="../../css/main.css">
<script type="text/javascript">
	function listdo(page) {
		f = document.sf;
		f.pageNum.value = page;
		f.submit();
	}
</script>
</head>
<body>
	<form action="list.do" method="post" name="sf">
		<div style="display: flex; justify-content: center;">
			<input type="hidden" name="pageNum" value="1"> <select
				name="column">
				<option value="">선택하세요</option>
				<option value="subject">제목</option>
				<option value="name">작성자</option>
				<option value="content">내용</option>
				<option value="subject,name">제목+작성자</option>
				<option value="subject,content">제목+내용</option>
				<option value="name,content">작성자+내용</option>
				<option value="subject,name,content">제목+작성자+내용</option>
			</select>
			<script>
				document.sf.column.value = "${param.column}";
			</script>
			<input type="text" name="find" value="${param.find}"
				style="width: 50%;"> <input type="submit" value="검색">
		</div>

	</form>

	<table class="w3-table-all">
		<caption>게시판 목록</caption>
		<c:if test="${boardcount == 0}">
			<tr>
				<td colspan="5">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>

		<c:if test="${boardcount > 0}">
			<tr>
				<td colspan="5" style="text-align: right">글개수 : ${boardcount}</td>
			</tr>
			<tr>
				<th width="8%">번호</th>
				<th width="50%">제목</th>
				<th width="14%">작성자</th>
				<th width="17%">등록일</th>
				<th width="11%">조회수</th>
			</tr>
			<c:forEach var="b" items="${list}">
				<tr>
					<td>${boardnum}</td>
					<c:set var="boardnum" value="${boardnum - 1}" />
					<td style="text-align: left"><c:if test="${!empty b.file1}">
							<a href="./file/${b.file1}" style="text-decoration: none;">@</a>
						</c:if> <c:if test="${empty b.file1}">&nbsp;&nbsp;&nbsp;</c:if> <%-- 답글의 level 만큼 들여쓰기 --%>
						<c:if test="${b.grplevel > 0}">
							<c:forEach var="i" begin="1" end="${b.grplevel}">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 </c:forEach>└
              </c:if> <a href="info.do?num=${b.num}">${b.subject}</a></td>
					<td>${b.name}</td>

					<%-- 오늘 등록된 게시물 날짜 format대로 출력하기 --%>
					<td><fmt:formatDate var="rdate" value="${b.regdate}"
							pattern="yyyy-MM-dd" /> <c:if test="${today == rdate}">
							<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss" />
						</c:if> <c:if test="${today != rdate}">
							<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm" />
						</c:if></td>
					<td>${b.readcnt}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="w3-center">
					<%-- 페이지 처리하기 --%> <c:if test="${pageNum <= 1}">[이전]</c:if> <c:if
						test="${pageNum > 1}">
						<a href="javascript:listdo(${pageNum - 1})">[이전]</a>
					</c:if> <c:forEach var="a" begin="${startpage}" end="${endpage}">
						<c:if test="${a == pageNum}">[${a}]</c:if>
						<c:if test="${a != pageNum}">
							<a href="javascript:listdo(${a})">[${a}]</a>
						</c:if>
					</c:forEach> <c:if test="${pageNum >= maxpage}">[다음]</c:if> <c:if
						test="${pageNum < maxpage}">
						<a href="javascript:listdo(${pageNum + 1})">[다음]</a>
					</c:if>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="5" style="text-align: right"><a href="writeForm.do">[글쓰기]</a>
			</td>
		</tr>
	</table>
</body>
</html>