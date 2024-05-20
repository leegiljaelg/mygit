package text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/putText.do")
public class PuttextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PuttextServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("EUC-KR");
	      String title = request.getParameter("TITLE");
	      String content = request.getParameter("CONTENT");
	      HttpSession session = request.getSession();
	      String id = (String)session.getAttribute("ID");
	      TextDAO dao = new TextDAO();
	      int seqno = dao.getSeqno() + 1;
	      Text text = new Text();
	      text.setSeqno(seqno);
	      text.setTitle(title);
	      text.setWriter(id);
	      text.setContent(content);
	      int result = dao.putText(text);
	      response.sendRedirect("MainPage.jsp?BODY=PutTextResult.jsp?R=" + result);
	}
}
