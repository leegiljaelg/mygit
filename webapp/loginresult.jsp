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
		if (result.equals("OK")) {
			String id = (String) session.getAttribute("ID");
		%>
		<font color="blue" size="4"> 로그인이 되었습니다. 어서오세요 <%=id%>님
		</font>
		<%
		} else {
		%>
		<font color="blue" size="4">로그인에 실패했습니다.<br/> 아이디랑 비밀번호를 다시 입력해주세요.</font>
		<%
		}
		%>
</body>
</html>