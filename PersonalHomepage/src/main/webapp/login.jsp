<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="loginstyle.css">
<style type="text/css"></style>
</head>
<body>
	<div class="loginpage">
		<h2 align="left">Login</h2><a href="MainPage.jsp?BODY=entry.jsp" id="entry">ȸ������</a>
		<form method="post" action="login.do" id="login" onsubmit="return check(this)">
			<input type="text" name="ID" placeholder="Id"> <input
				type="password" name="PWD" placeholder="Password"> <input
				type="submit" value="�α���">
		</form>
		<script type="text/javascript">
			function check(frm) {
				if (frm.ID.value == '') {
					alert("���̵� �Է��ϼ���.");
					frm.ID.focus();
					return false;
				}
				if (frm.PWD.value == '') {
					alert("��ȣ�� �Է��ϼ���.");
					frm.PWD.focus();
					return false;
				}
			}
		</script>
	</div>
</body>
</html>