<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>�� �ۼ��ϱ�</h2>
		<form action="putText.do" method="post">
			�� �� : <input type="text" name="TITLE" placeholder="������ �Է��ϼ���."
				size="20"><br />
			<br /> �� �� : <br />
			<textarea rows="10" cols="40" name="CONTENT"></textarea>
			<br />
			<br /> <input type="submit" value="�� �ø���"> <input
				type="reset" value="�� ��">
		</form>
	</div>
</body>
</html>