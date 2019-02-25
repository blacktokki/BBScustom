<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list</title>
</head>
<body>
	<table style="width:500; cellpadding:0; cellspacing:0;" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.idx}</td>
			<td>${dto.bdname}</td>
			<td>
				<c:forEach begin="1" end="${dto.indent}">-</c:forEach>
				<a href="content_view?idx=${dto.idx}">${dto.title}</a>
			</td>
			<td>${dto.bddate}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
	</table>

</body>
</html>