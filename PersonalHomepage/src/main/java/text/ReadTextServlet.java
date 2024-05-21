package text;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/ReadText.do" })
public class ReadTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("PAGE");
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int startPage = (currentPage - 1) * 5 + 1;
		int endPage = currentPage * 5;
		TextDAO dao = new TextDAO();
		int totalCount = dao.getTotalText();
		if (endPage > totalCount) {
			endPage = totalCount;
		}

		ArrayList<Text> list = dao.readText(startPage, endPage);
		int pageCount = totalCount / 5;
		if (totalCount % 5 != 0) {
			++pageCount;
		}

		request.setAttribute("TEXT", list);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("MainPage.jsp?BODY=readTextResult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
