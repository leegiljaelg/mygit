<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>글 작성하기</h2>
		<form action="putText.do" method="post">
			제 목 : <input type="text" name="TITLE" placeholder="제목을 입력하세요."
				size="20"><br />
			<br /> 내 용 : <br />
			<textarea rows="10" cols="40" name="CONTENT"></textarea>
			<br />
			<br /> <input type="submit" value="글 올리기"> <input
				type="reset" value="취 소">
		</form>
	</div>
</body>
</html>