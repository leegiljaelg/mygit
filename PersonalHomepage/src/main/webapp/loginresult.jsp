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
		if (result.equals("OK")) {
			String id = (String) session.getAttribute("ID");
		%>
		<font color="blue" size="4"> �α����� �Ǿ����ϴ�. ������� <%=id%>��
		</font>
		<%
		} else {
		%>
		<font color="blue" size="4">�α��ο� �����߽��ϴ�.<br/> ���̵�� ��й�ȣ�� �ٽ� �Է����ּ���.</font>
		<%
		}
		%>
</body>
</html>