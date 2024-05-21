<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	color: white;
	background-image: url("background.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

table {
	text-align: center;
	color: black;
	background-color: white;
	width: 80%;
	height: 80%;
	color: black;
}

#menu {
	margin-bottom: 10px;
	margin-left: 10px;
	margin-right: 10px;
	margin-top: 10px;
	padding: 10px
}

#jsp {
	margin-bottom: 10px;
	margin-left: 10px;
	margin-right: 10px;
	margin-top: 10px;
	background-color: white;
	border-radius: 10px;
}
</style>
</head>
<body>
	<header>
		<h2 align="center">My HomePage</h2>
	</header>
	<section>
		<div align="center">
			<table border="1" id="body">
				<tr>
					<td width="20%">
						<div align="center" id="jsp">
							<%
							String id = (String) session.getAttribute("ID");
							if (id == null) {
							%>
							<jsp:include page="login.jsp"></jsp:include>
							<%
							} else {
							%>
							<jsp:include page="logout.jsp"></jsp:include>
							<%
							}
							%>
						</div>
						<div align="center" id="menu">
							<a href="MainPage.jsp?BODY=showkai.jsp"> 소개</a><br /> 
							<%
							if (id != null) {
							%>
							<a href="MainPage.jsp?BODY=textpage.jsp">게시판 작성</a><br />
							<%
							}
							%>
							<a href="ReadText.do">게시판</a><br />
						</div>
					</td>
					<td id="content" width="80%">
						<%
						String body = request.getParameter("BODY");
						if (body == null) {
						%> <jsp:include page="showkai.jsp"></jsp:include> <%
 } else {
 %> <jsp:include page="<%=body%>"></jsp:include> <%
 }
 %>
					</td>
				</tr>
			</table>
		</div>
	</section>
	<footer>
		<h3 align="center">Copyright 2024.MyHomePage.Kosea HRD</h3>
	</footer>
</body>
</html>