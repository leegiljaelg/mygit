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
	<script type="text/javascript">
		alert("�Խñ��� �����Ǿ����ϴ�.");
		location.href("ReadText.do");
	</script>
	<%
	} else {
	%>
	<script type="text/javascript">
		alert("�Խñ� ������ �����߽��ϴ�.");
		location.href("ReadText.do");
	</script>
	<%
	}
	%>
</body>
</html>