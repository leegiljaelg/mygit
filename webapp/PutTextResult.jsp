<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<%
		String result = request.getParameter("R");
		if (result.equals("1")) {
		%>
		<script type="text/javascript">
			alert("�Խñ��� ��ϵǾ����ϴ�.");
			location.href = "ReadText.do";//�Խñ� ����� ����Ѵ�.�̿ϼ����� �ϼ��� ReadText.do�� �ٲ۴�.
		</script>
		<%
		} else {
		%>
		<script type="text/javascript">
			alert("�Խñ��� ��ϵ��� �ʾҽ��ϴ�. �ٽ� Ȯ���� �ּ���.");
			location.href = "ReadText.do";//�Խñ� ����� ����Ѵ�.�̿ϼ����� �ϼ��� ReadText.do�� �ٲ۴�.
		</script>
		<%
		}
		%>
	</div>
</body>
</html>