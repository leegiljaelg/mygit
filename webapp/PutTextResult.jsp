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
			alert("게시글이 등록되었습니다.");
			location.href = "ReadText.do";//게시글 목록을 출시한다.미완성으로 완성후 ReadText.do로 바꾼다.
		</script>
		<%
		} else {
		%>
		<script type="text/javascript">
			alert("게시글이 등록되지 않았습니다. 다시 확인해 주세요.");
			location.href = "ReadText.do";//게시글 목록을 출시한다.미완성으로 완성후 ReadText.do로 바꾼다.
		</script>
		<%
		}
		%>
	</div>
</body>
</html>