<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">���� �ߺ� Ȯ��</h2>
	<form action="idCheck.do" name="checkFrm">
		<%
		String id = (String) request.getAttribute("ID");
		String result = (String) request.getAttribute("RESULT");
		%>
		���� : <input type="text" name="ID" value="<%=id%>"/><input
			type="submit" value="�ߺ��˻�"/>
	</form>
	<%
	if (result == null) {
	%>
	<%=id%>�� ��� �����մϴ�
	<input type="button" value="����ϱ�" onclick="idOK()">
	<%
	} else {
	%>
	<%=id%>�� �̹� ����ϰ� �ֽ��ϴ�.
	<%
	}
	%>
	<script type="text/javascript">
	function idOK(){
		var id = document.checkFrm.ID.value;
		opener.document.frm.ID.value = id;
		opener.document.frm.ID.readOnly = true;
		opener.document.frm.idChecked.value = "OK";
		self.close();
	}
	</script>
</body>
</html>