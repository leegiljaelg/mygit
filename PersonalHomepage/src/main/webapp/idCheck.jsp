<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">계정 중복 확인</h2>
	<form action="idCheck.do" name="checkFrm">
		<%
		String id = (String) request.getAttribute("ID");
		String result = (String) request.getAttribute("RESULT");
		%>
		계정 : <input type="text" name="ID" value="<%=id%>"/><input
			type="submit" value="중복검사"/>
	</form>
	<%
	if (result == null) {
	%>
	<%=id%>는 사용 가능합니다
	<input type="button" value="사용하기" onclick="idOK()">
	<%
	} else {
	%>
	<%=id%>는 이미 사용하고 있습니다.
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