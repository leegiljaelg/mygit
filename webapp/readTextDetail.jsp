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
	<h2>�Խñ� ��</h2>
		<table>
			<tr>
				<th>�۹�ȣ</th>
				<td><%=text.getSeqno()%></td>
			</tr>
			<tr>
				<th>����</th>
				<td><%=text.getTitle()%></td>
			</tr>
			<tr>
				<th>�ۼ���</th>
				<td><%=text.getWriter()%></td>
			</tr>
			<tr>
				<th>�ۼ���</th>
				<td><%=text.getText_date()%></td>
			</tr>
			<tr>
				<th>�ۼ���</th>
				<td><textarea rows="5" cols="40" readonly="readonly"><%=text.getContent()%></textarea></td>
			</tr>
		</table>
	</div>
</body>
</html>