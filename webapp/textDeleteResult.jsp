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
		alert("게시글이 삭제되었습니다.");
		location.href("ReadText.do");
	</script>
	<%
	} else {
	%>
	<script type="text/javascript">
		alert("게시글 삭제에 실패했습니다.");
		location.href("ReadText.do");
	</script>
	<%
	}
	%>
</body>
</html>