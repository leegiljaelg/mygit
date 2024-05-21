package text;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/textDetailModify.do" })
public class TextDetailModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String seqno = request.getParameter("SEQNO");
		String btn = request.getParameter("BTN");
		TextDAO dao = new TextDAO();
		if (btn.equals("수정하기")) {
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			int result = dao.updateText(Integer.parseInt(seqno), title, content);
			response.sendRedirect("MainPage.jsp?BODY=textUpdateResult.jsp?R=" + result);
		} else if (btn.equals("삭제하기")) {
			int result = dao.deleteText(Integer.parseInt(seqno));
			response.sendRedirect("MainPage.jsp?BODY=textDeleteResult.jsp?R=" + result);
		}

	}
}
