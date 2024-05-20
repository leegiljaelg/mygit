package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TextDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public int updateText(int seqno, String title, String content) {
		String q = "update myshop_text_tbl set title = ?, content = ? where seqno = ?";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, seqno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글 수정 중 문제 발생!!!!");
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

	public int deleteText(int seqno) {
		String q = "delete from myshop_text_tbl where seqno = ?";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, seqno);
			result = pstmt.executeUpdate();
		} catch (Exception var13) {
			System.out.println("게시판 삭제 중 문제 발생!!!");
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public Text getDetailText(int seqno) {
		String q = "select seqno, title, writer, content,  to_char(text_date, 'YYYY-MM-DD')  from myshop_text_tbl where seqno = ?";
		Text text = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, seqno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				text = new Text();
				text.setSeqno(rs.getInt(1));
				text.setTitle(rs.getString(2));
				text.setWriter(rs.getString(3));
				text.setContent(rs.getString(4));
				text.setText_date(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("게시글 상세조회 중 문제발생!!!");
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return text;
	}

	public int getTotalText() {
		String q = "select count(*) from myshop_text_tbl";
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("게시글의 갯수를 찾는 중 문제발생!!!");
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public ArrayList<Text> readText(int start, int end) {
		String q = "select seqno, title, writer, entry "
				+ "from (select rownum rn, seqno, title, writer, entry "
				+ "from (select seqno, title, writer, " 
				+ "to_char(text_date, 'YY/MM/DD') entry "
				+ "from myshop_text_tbl order by seqno desc)) "
				+ "where rn >=? and rn <= ?";
		ArrayList<Text> list = new ArrayList<Text>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Text text = new Text();
				text.setSeqno(rs.getInt(1));
				text.setTitle(rs.getString(2));
				text.setWriter(rs.getString(3));
				text.setText_date(rs.getString(4));
				list.add(text);
			}
		} catch (Exception e) {
			System.out.println("게시글 검색 중 문제 발생!!!");
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public int putText(Text text) {
		String q = "insert into myshop_text_tbl values(?,?,?,?,sysdate)";
		int result = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, text.getSeqno());
			pstmt.setString(2, text.getTitle());
			pstmt.setString(3, text.getWriter());
			pstmt.setString(4, text.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception var13) {
			System.out.println("게시글 등록 중 문제 발생!!!");
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

	public int getSeqno() {
		String q = "select max(seqno) from myshop_text_tbl";
		int seqno = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			pstmt = con.prepareStatement(q);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				seqno = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("글번호 검색 중 문제 발생!!!");
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
			}
		}
		return seqno;
	}
}
