<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write_view</title>
</head>
<body>
	<form action="write" method="post">
		<table style="width:500; cellpadding:0; cellspacing:0;" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bdname" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10"></textarea></td>
			</tr>
			<tr>
				 <td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;<a href="list">목록보기</a></td>
			</tr>
		</table>
	</form>

</body>
</html>