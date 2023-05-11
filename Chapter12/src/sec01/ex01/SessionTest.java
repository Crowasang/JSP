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
		
		// ���� ��ü ��������
		HttpSession session = request.getSession();
		// ���� ��ü�� name ���ε�
		session.setAttribute("name", "�赿��");
		
		out.print("<html><body>");
		out.print("<h1>���ǿ� �̸��� ���ε��մϴ�.</h1>");
		out.print("<a href='/Chapter12/session/session1.jsp'>ù ��° �������� �̵�</a>");
		out.print("</body></html>");
		
	}

}
