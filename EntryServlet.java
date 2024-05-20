package entry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.User;

@WebServlet("/entry.do")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EntryServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		String name = request.getParameter("NAME");
		String addr = request.getParameter("ADDR");
		String tel = request.getParameter("TEL");
		String email = request.getParameter("EMAIL");
		String gender = request.getParameter("GENDER");
		String job = request.getParameter("JOB");
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		user.setName(name);
		user.setAddress(addr);
		user.setTel(tel);
		user.setEmail(email);
		user.setGender(gender);
		user.setJob(job);
		EntryDAO dao = new EntryDAO();
		int result = dao.entry(user);
		response.sendRedirect("MainPage.jsp?BODY=EntryResult.jsp?R="+result);
		
	}

}
