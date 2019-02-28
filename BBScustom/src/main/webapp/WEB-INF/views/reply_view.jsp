<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply_view</title>
</head>
<body>
	<form action="reply" method="post">
	<input type="hidden" name="idx" value="${reply_view.idx}">
	<input type="hidden" name="bdgroup" value="${reply_view.bdgroup}">
	<input type="hidden" name="step" value="${reply_view.step}">
	<input type="hidden" name="indent" value="${reply_view.indent}">
		<table style="width:500; cellpadding:0; cellspacing:0;" border="1">
			<tr>
				<td>번호</td>
				<td>${reply_view.idx}</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${reply_view.hit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bdname" value="${reply_view.bdname}" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="RE:${reply_view.title}" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10">${reply_view.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변">&nbsp;&nbsp;
					<a href="list">목록보기</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>