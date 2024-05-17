package text;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/detailText.do"})
public class DetailTextServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String seqno = request.getParameter("NO");
      TextDAO dao = new TextDAO();
      Text text = dao.getDetailText(Integer.parseInt(seqno));
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("ID");
      request.setAttribute("TEXT", text);
      RequestDispatcher rd;
      if (id != null && text.getWriter().equals(id)) {
         rd = request.getRequestDispatcher("MainPage.jsp?BODY=readTextDetailOwner.jsp");
         rd.forward(request, response);
      } else {
         rd = request.getRequestDispatcher("MainPage.jsp?BODY=readTextDetail.jsp");
         rd.forward(request, response);
      }

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   }
}
