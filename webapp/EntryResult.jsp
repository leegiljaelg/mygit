<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	String result = request.getParameter("R");
	if (result.equals("1")) {
	%>
		<font color="blue">회원가입이 되었습니다.</font>
	<%
	} else {
	%>
		<font color="blue">회원가입에 실패했습니다. 다시 입력해주세요.</font>
	<%
	}
	%>
</body>
</html>