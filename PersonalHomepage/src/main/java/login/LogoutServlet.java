package login;
// パッケージ login 宣言
import java.io.IOException;
// java.io パッケージからIOExceptionクラスを持ってきて使用(import)
// IException:入力および出力作業中に発生しうる一般的な例外を示すクラス
import javax.servlet.ServletException;
// javax.servletからServletExceptionクラスを持ってきて使用(import)
// ServletException:サーブレットで発生しうる例外を示すクラス
import javax.servlet.annotation.WebServlet;
// javax.servlet.annotationからWebServletアノテーションを取得して使用（import）
// WebServlet:サーブレットクラスを定義するときに使用、サーブレットのURLパターンに関する情報を設定するために使用するアノテーション
// アノテーション: メタデータを提供する特殊な形態のインターフェース
import javax.servlet.http.HttpServlet;
// javax.servlet.httpでHttpServletクラスを持ってきて使用(import)
// HttpServlet:Servletプログラミングをする時、HTTP要求を処理するための基本クラス
import javax.servlet.http.HttpServletRequest;
// javax.servlet.httpでHttpServletRequestクラスを持ってきて使用(import)
// HttpServletRequest:HTTP要請情報をサブラットに伝達するために使用されるオブジェクト
import javax.servlet.http.HttpServletResponse;
// javax.servlet.httpでHttpServletResponseクラスを持ってきて使用(import)
// HttpServletResponse:サーブレットでクライアントに応答を作成して送信するのに使用
import javax.servlet.http.HttpSession;
// javax.servlet.httpでHttpSessionクラスを持ってきて使用(import)
// HttpSession:ウェブアプリケーションでクライアントとサーバー間のセッションを管理するのに使用
@WebServlet("/logout.do")
// Javaサブレットのアノテーション、「logout.do 」URLパターンとマッピングされるよう設定
public class LogoutServlet extends HttpServlet {
// LogoutServletクラスがHttpServletクラスを継承する
	private static final long serialVersionUID = 1L;
	// 直列化されたオブジェクトのバージョンを表す定数
	public LogoutServlet() {
	}
	// サーブレットの基本生成者
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	// HTTP GET要求を処理するメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// HTTPPOSTリクエストを処理するメソッド
		request.setCharacterEncoding("EUC-KR");
		// リクエストエンコードをEUC-KRに設定
		HttpSession session = request.getSession();
		// 現在のリクエストからセッション オブジェクトを取得します。
		session.invalidate();
		// セッションを無効にしてすべてのセッション データを削除= ユーザーをログアウト
		response.sendRedirect("MainPage.jsp?BODY=logoutresult.jsp");
		// ログアウト後、ユーザーをMainPage.jspページにダイレクト、URLクエリパラメータBODY=logoutresult.jspでログアウト結果ページを表示
	}

}
