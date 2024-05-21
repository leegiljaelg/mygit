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
		<form action="entry.do" method="post" name="frm" onsubmit="return check(this)">
			<h2>회원가입</h2>
			ID : <input type="text" size="6" name="ID" id="id"> 
			<input type="button" value="중복확인" onclick="idCheck()">
			<input type="hidden" name="idChecked"> <br />
			 PW : <input type="password" name="PWD"><br /> 
			 PW 확인 : <input type="password" name="CONFIRM"><br /> 
			 이름 : <input type="text" size="6" name="NAME"><br /> 
			 주소 : <input type="text" name="ADDR"><br /> 
			 전화번호 : <input type="text" name="TEL"><br /> 
			 Email : <input type="text" name="EMAIL"><br />
			 성별 : 남 <input type="radio" name="GENDER" value="남"> 
			 	   여 <input type="radio" name="GENDER" value="여"><br /> 
			 직업 : <select name="JOB">
				<option>회사원</option>
				<option>학생</option>
				<option>기타</option>
			</select><br /> <br /> 
			<input type="submit" value="가입하기"> 
			<input type="reset" value="취 소">
		</form>
	</div>
	<script type="text/javascript">
	function idCheck() {
		if(document.frm.ID.value == ''){
			alert("계정을 입력하세요.")
			document.frm.ID.focus();
			return false;
		}
		var url = "idCheck.do?ID=" + document.frm.ID.value;//서블릿의 결과->JSP
		window.open(url, "_blank_", "width=450, height=200");
	}
	function check(frm) {
		if (frm.ID.value == '') {
			alert("아이디를 입력하세요")
			frm.ID.focus();
			return false;
		}
		if (frm.idChecked.value == '') {
			alert("중복검사를 실행해주세요")
			return false;
		}
		if (frm.PWD.value == '') {
			alert("비밀번호를 입력하세요")
			frm.PWD.focus();
			return false;
		}
		if (frm.PWD.value != frm.CONFIRM.value) {
			alert("암호가 일치하지 않습니다.")
			frm.PWD.focus();
			return false;
		}
		if (frm.NAME.value == '') {
			alert("이름을 입력하세요")
			frm.NAME.focus();
			return false;
		}
		if (frm.ADDR.value == '') {
			alert("주소을 입력하세요")
			frm.ADDR.focus();
			return false;
		}
		if (frm.TEL.value == '') {
			alert("전화번호를 입력하세요")
			frm.TEL.focus();
			return false;
		}
		if (frm.EMAIL.value == ''){
			alert("이메일을 입력하세요.")
			frm.EMAIL.focus();
			return false;
		}
		if (!frm.GENDER[0].checked && !frm.GENDER[1].checked) {
			alert("성별을 선택하세요.")
			return false;
		}
		if(!confirm("해당 정보로 가입하시겠습니까?"))
			return false;
	}
	</script>
</body>
</html>