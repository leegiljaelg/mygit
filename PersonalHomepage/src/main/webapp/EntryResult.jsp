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
		<font color="blue">ȸ�������� �Ǿ����ϴ�.</font>
	<%
	} else {
	%>
		<font color="blue">ȸ�����Կ� �����߽��ϴ�. �ٽ� �Է����ּ���.</font>
	<%
	}
	%>
</body>
</html>