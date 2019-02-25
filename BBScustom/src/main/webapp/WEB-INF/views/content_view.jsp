<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>write_view</title>
</head>
<body>
	<form action="write" method="post">
	<input type="hidden" name="idx" value="${content_view.idx}">
		<table style="width:500; cellpadding:0; cellspacing:0;" border="1">
			<tr>
				<td>번호</td>
				<td>${content_view.idx}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${content_view.hit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bdname" value="${content_view.bdname}" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${content_view.title}" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10">${content_view.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;<a href="list">목록보기</a>&nbsp;&nbsp;<a href="delete">삭제하기</a></td>
			</tr>
		</table>
	</form>

</body>
</html>