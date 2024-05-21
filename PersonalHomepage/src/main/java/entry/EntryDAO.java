package entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.User;

public class EntryDAO {
	public EntryDAO() {}
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public int entry(User user) {//가입 내용 넣기
		String q = "insert into myshop_users_tbl values(?,?,?,?,?,sysdate,?,?,?)";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getTel());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getPwd());
			pstmt.setString(8, user.getJob());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("정보 입력 중 문제 발생!!!");
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
	public String idCheckUP(String id) {
		String q = "select id from myshop_users_tbl where id = ?";
		String result = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("아이디 중복 검사 중 문제 발생!!!");
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
}
