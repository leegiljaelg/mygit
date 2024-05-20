package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public LoginDAO() {
	}

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public String loginCheck(String id, String password) {
		String q = "select id, pwd from myshop_users_tbl where id = ?";
		String result = "NOK";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pwd = rs.getString(2);
				if (pwd.equals(password)) {
					result = "OK";
				}
			}
		} catch (Exception e) {
			System.out.println("아이디 검색 중 오류 발생!!!");
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
}
