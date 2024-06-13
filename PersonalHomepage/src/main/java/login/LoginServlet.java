package login;
//package:Javaファイルの一番上に位置、ファイルが属するパッケージを定義
import java.io.IOException;
//javax.servlet:Javaウェブアプリケーションでサーブレットに関するクラスおよびインターフェースを提供
//ServletException:Javaウェブアプリケーションで発生しうるサーブレット例外を示すクラス
//annotation:Javaプログラミング言語のメタデータであり、クラス、メソッド、変数などに対する付加的な情報を提供
//HttpServlet:JavaウェブアプリケーションでHTTPプロトコルを処理するサーブレットを作成するための基本クラスの一つ
//HttpServletRequest:JavaウェブアプリケーションでクライアントからのHTTP要請を表すオブジェクト
//HttpServletResponse:Javaウェブアプリケーションからクライアントに応答を送るためのオブジェクト
//HttpSession:Javaウェブアプリケーションでクライアントとサーバー間の状態維持のためのセッションを表すオブジェクト
//javax.xml.ws.Response:Java API for XML Web Services（JAX-WS）で使用されるクラス、Webサービスのリクエストに対する応答を示すときに使用
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

@WebServlet("/login.do")
//@WebServlet:Java EEおよびJakarta EEで使用されるアナテーションで、サーブレットを宣言してマッピングするときに使用
// サブレットを特定のURLパターンにマッピングするために使用(login.do）
public class LoginServlet extends HttpServlet {
//public:すべてのクラスのアクセス許可
//extends:クラス継承、一つのクラスが異なるクラスの特性(フィールドとメソッド)を継承して拡張する概念
//HttpServlet : javax。servlet.http パッケージに属し、javax.servlet.http.HttpServletを継承して使用
//LoginServlet クラスはHttpServlet を継承している。
	private static final long serialVersionUID = 1L;
//private:外部のアクセス不可能、同じクラス内でのみアクセス可能
//static:クラスレベルの変数、すべてのオブジェクトが同じ値を共有
//final:一度初期化されると変更できない定数
//long:整数形(long)データタイプ
//static final long:ジャワで定数を宣言する方法
//serial Version UID:Java直列化で使用されるバージョン番号を表すフィールド、直列化されたオブジェクトが再び逆直列化されたとき、クラスのバージョンが互換性があるかを確認するときに使用
//直列化されたオブジェクトのバージョンを表す定数を宣言すること
	public LoginServlet() {
	}
// クラスの生成者: サーブレット インスタンスが生成されるときに呼び出されるメソッド、初期化タスクを実行または必要なリソースを割り当てるときに使用
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
//protected:継承されたクラスor同じパッケージでのみアクセス可能
//void:ジャワでメソッドや関数が返す値のタイプがないことを示す
//doGet:クライアントからGET要求を処理します。 フォームを表示したり、ページを照会するなどの作業に使用
//HttpServletRequestrequest:クライアントからサーバに要求された情報（request）を含むオブジェクト
//HttpServletResponse response:サーブレットがクライアントに応答(response)を送るときに使用されるオブジェクト
//throws:メソッドや生成者から発生しうる例外を宣言するときに使用
//ServletException:サーブレットで発生する例外を示すクラス、サーブレットでの作業中に予期しない問題が発生したときに使用
//HttpServletクラスから継承されたサーブレットクラスで実装され、クライアントからのHTTP GET要求を処理して応答を生成します。
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//doPost:クライアントからPOST要求を処理します。 フォームデータを受信して処理するロジック付き
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		LoginDAO dao = new LoginDAO();
		String result = dao.loginCheck(id, pwd);
		if (result.equals("OK")) {
			HttpSession session = request.getSession();
			session.setAttribute("ID", id);
		}
		response.sendRedirect("MainPage.jsp?BODY=loginresult.jsp?R=" + result);

	}
//setCharacterEncoding:HTTPリクエストまたは応答の文字エンコードを設定するのに使用
//String:Javaで文字列を表すのに使用されるクラス
//getParameter:クライアントのHTTP要求から特定の名前(name)のパラメータ値を取得するために使用
//getSession: HTTPセッションを取得するために使用
//setAttribute:HTTPセッション、HttpServletRequest、ServletRequest、ServletContextなどのオブジェクトにプロパティ(attribute)を設定するのに使用します
//sendRedirect:クライアントに別のページにリダイレクトするときに使用、指定されたURLにリダイレクトされ、クライアントは新しいページに移動します。
}
