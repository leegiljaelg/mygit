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
			<h2>ȸ������</h2>
			ID : <input type="text" size="6" name="ID" id="id"> 
			<input type="button" value="�ߺ�Ȯ��" onclick="idCheck()">
			<input type="hidden" name="idChecked"> <br />
			 PW : <input type="password" name="PWD"><br /> 
			 PW Ȯ�� : <input type="password" name="CONFIRM"><br /> 
			 �̸� : <input type="text" size="6" name="NAME"><br /> 
			 �ּ� : <input type="text" name="ADDR"><br /> 
			 ��ȭ��ȣ : <input type="text" name="TEL"><br /> 
			 Email : <input type="text" name="EMAIL"><br />
			 ���� : �� <input type="radio" name="GENDER" value="��"> 
			 	   �� <input type="radio" name="GENDER" value="��"><br /> 
			 ���� : <select name="JOB">
				<option>ȸ���</option>
				<option>�л�</option>
				<option>��Ÿ</option>
			</select><br /> <br /> 
			<input type="submit" value="�����ϱ�"> 
			<input type="reset" value="�� ��">
		</form>
	</div>
	<script type="text/javascript">
	function idCheck() {
		if(document.frm.ID.value == ''){
			alert("������ �Է��ϼ���.")
			document.frm.ID.focus();
			return false;
		}
		var url = "idCheck.do?ID=" + document.frm.ID.value;//������ ���->JSP
		window.open(url, "_blank_", "width=450, height=200");
	}
	function check(frm) {
		if (frm.ID.value == '') {
			alert("���̵� �Է��ϼ���")
			frm.ID.focus();
			return false;
		}
		if (frm.idChecked.value == '') {
			alert("�ߺ��˻縦 �������ּ���")
			return false;
		}
		if (frm.PWD.value == '') {
			alert("��й�ȣ�� �Է��ϼ���")
			frm.PWD.focus();
			return false;
		}
		if (frm.PWD.value != frm.CONFIRM.value) {
			alert("��ȣ�� ��ġ���� �ʽ��ϴ�.")
			frm.PWD.focus();
			return false;
		}
		if (frm.NAME.value == '') {
			alert("�̸��� �Է��ϼ���")
			frm.NAME.focus();
			return false;
		}
		if (frm.ADDR.value == '') {
			alert("�ּ��� �Է��ϼ���")
			frm.ADDR.focus();
			return false;
		}
		if (frm.TEL.value == '') {
			alert("��ȭ��ȣ�� �Է��ϼ���")
			frm.TEL.focus();
			return false;
		}
		if (frm.EMAIL.value == ''){
			alert("�̸����� �Է��ϼ���.")
			frm.EMAIL.focus();
			return false;
		}
		if (!frm.GENDER[0].checked && !frm.GENDER[1].checked) {
			alert("������ �����ϼ���.")
			return false;
		}
		if(!confirm("�ش� ������ �����Ͻðڽ��ϱ�?"))
			return false;
	}
	</script>
</body>
</html>