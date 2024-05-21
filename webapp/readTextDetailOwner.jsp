<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	Text text = (Text) request.getAttribute("TEXT");
	%>
	<div align="center">
		<h2>게시글 내용</h2>
		<form action="textDetailModify.do" method="post"
			onsubmit="return check()">
			<input type="hidden" name="SEQNO" value="<%=text.getSeqno()%>">
			<table>
				<tr>
					<th>글번호</th>
					<td><%=text.getSeqno()%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="TITLE"
						value="<%=text.getTitle()%>>"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=text.getWriter()%></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><%=text.getText_date()%></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><textarea rows="5" cols="40" name = "CONTENT"><%=text.getContent()%></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="수정하기" name="BTN"> <input type="submit" value="삭제하기"
						name="BTN" /></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			function check() {
				if (!confirm("정말로 해당 작업을 수행하시겠습니까?"))
					return false;
			}
		</script>
	</div>
</body>
</html>