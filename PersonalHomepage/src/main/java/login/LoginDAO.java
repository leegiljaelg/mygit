package login;
//パッケージ宣言
import java.sql.Connection;
// java.sqlパッケージからConnectionクラスを持ってきて使用する。(import)
// Connection:SQLデータベースとの接続を管理
import java.sql.DriverManager;
// java.sqlパッケージからDriverManagerクラスを持ってきて使う。(import)
// DriverManager:JDBCでデータベースドライバを管理、データベース接続設定
import java.sql.PreparedStatement;
// java.sqlパッケージからPrepared Statementクラスを持ってきて使用する。(import)
// Prepared Statement:SQL文をあらかじめコンパイルして性能を向上させ、インジェクション攻撃を防止するのに役立つ。
import java.sql.ResultSet;
// java.sqlパッケージからResultSetクラスを持ってきて使用する(import)
// ResultSet:クエリーの結果を保存し、結果を巡回してデータを読み取ることができるようにする。
public class LoginDAO { // LoginDAOクラス宣言
	public LoginDAO() { // 基本生成器
	}

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	// クラス内で使用される変数宣言
	public boolean loginCheck(String id, String password) { //loginCheck マサード宣言
	// アクセス制御子(public) / 返却タイプ(boolean) - true or false / メソッド名(loginCheck) / 媒介変数リスト(Stringid, Stirng password) / マサード本文
		String query = "select id, pwd from myshop_users_tbl where id = ?";
		// データベースでユーザIDとパスワードを照会するSQLクエリ、「?」はプレイスホルダー、実際の値はPreparedStatementを使用して決定
		// query:データベースに情報を求めること
		boolean result = false;
		// ログインの成否を保存する変数。 基本値はfalse、成功時trueに設定
		try { // 例外処理、データベース接続、およびクエリ実行を試みる
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle JDBCドライバーをロード、Oracleデータベースとの接続が可能
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// データベースURL(jdbc~:xe)、ユーザ名(hr)、パスワード(hr)を使用してデータベースに接続
			pstmt = con.prepareStatement(query);
			// 用意されたクエリ、クエリを実行する準備
			pstmt.setString(1, id);
			// プレースホルダー値の設定、クエリーの最初の再プレースホルダー '?' にユーザーIDの設定
			rs = pstmt.executeQuery();
			// クエリー実行、結果をResultSet オブジェクトとして受け取る。
			if (rs.next()) { // 結果セットで最初のレコードがあることを確認
				String pwd = rs.getString(2);
				// 2 番目の列(パスワード)を取得します。
				if (pwd.equals(password)) {
				// データベースから取得したパスワードと入力したパスワードを比較
					result = "true";
					// 一致するとresultをtrueに設定
				}
			}
		} catch (Exception e) { // 例外発生時にエラーメッセージを出力
			System.out.println("아이디 검색 중 오류 발생!!!");
			// java.lang.systemクラス内部にoutというprintStreamオブジェクトが持っているprintin()メソッドを使用すること
		} finally { // 資源を解体
			try {
				con.close();
				pstmt.close();
				rs.close();
				// データベース接続、Prepared Statement、ResultSetを閉じる。
			} catch (Exception e) {
			}
		}
		return result;
		// メソッドで計算した結果を呼び出したところに返す。 true or falseか
	}
}
