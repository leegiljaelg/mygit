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
		<h2>�Խñ� ����</h2>
		<form action="textDetailModify.do" method="post"
			onsubmit="return check()">
			<input type="hidden" name="SEQNO" value="<%=text.getSeqno()%>">
			<table>
				<tr>
					<th>�۹�ȣ</th>
					<td><%=text.getSeqno()%></td>
				</tr>
				<tr>
					<th>����</th>
					<td><input name="TITLE"
						value="<%=text.getTitle()%>>"></td>
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
					<td><textarea rows="5" cols="40" name = "CONTENT"><%=text.getContent()%></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="�����ϱ�" name="BTN"> <input type="submit" value="�����ϱ�"
						name="BTN" /></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			function check() {
				if (!confirm("������ �ش� �۾��� �����Ͻðڽ��ϱ�?"))
					return false;
			}
		</script>
	</div>
</body>
</html>