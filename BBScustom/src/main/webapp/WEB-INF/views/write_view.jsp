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
		<table style="width:500; cellpadding:0; cellspacing:0;" border="1">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="bdname" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><textarea name="content" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="input">&nbsp;&nbsp;</td>
			</tr>
		</table>
	</form>

</body>
</html>