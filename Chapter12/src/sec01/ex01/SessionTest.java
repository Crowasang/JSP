package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/session1")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		// 세션 객체에 name 바인딩
		session.setAttribute("name", "김동현");
		
		out.print("<html><body>");
		out.print("<h1>세션에 이름을 바인딩합니다.</h1>");
		out.print("<a href='/Chapter12/session/session1.jsp'>첫 번째 페이지로 이동</a>");
		out.print("</body></html>");
		
	}

}
