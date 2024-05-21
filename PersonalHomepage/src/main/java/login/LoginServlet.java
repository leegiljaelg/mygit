package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

}
