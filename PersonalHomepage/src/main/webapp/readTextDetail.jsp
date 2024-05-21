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
	<h2>게시글 상세</h2>
		<table>
			<tr>
				<th>글번호</th>
				<td><%=text.getSeqno()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=text.getTitle()%></td>
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
				<td><textarea rows="5" cols="40" readonly="readonly"><%=text.getContent()%></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>