<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<Text> list = (ArrayList<Text>) request.getAttribute("TEXT");
	int count = list.size();
	int pages = (int) request.getAttribute("PAGES");
	%>
	<div align="center">
	<h2>�Խñ�</h2>
		<table width="100%">
			<tr>
				<th>�۹�ȣ</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
			</tr>
			<%
			for (int i = 0; i < count; i++) {
				Text text = list.get(i);
			%>
			<tr>
				<td><%=text.getSeqno()%></td>
				<td><a href="detailText.do?NO=<%=text.getSeqno()%>"><%=text.getTitle()%></a></td>
				<td><%=text.getWriter()%></td>
				<td><%=text.getText_date()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		for (int i = 1; i <= pages; i++) {
		%>
		<a href="ReadText.do?PAGE=<%=i%>"><%=i%></a>
		<%
		}
		%>
	</div>
</body>
</html>