<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 80%;
	height: 80%;
}
</style>
</head>
<body>
	<%
	String id = (String) session.getAttribute("ID");
	%>
	<form method="post" action="logout.do" id="logout">
		<div>
			<table>
				<tr>
					<td><img alt="User Image" src="user.jpg" width="30"
						height="30"></td>
					<td><%=id%></td>
					<td><input type="submit" value="로그아웃"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>