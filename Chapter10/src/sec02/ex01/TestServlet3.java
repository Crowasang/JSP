package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();	//context �̸� ������
		String url = request.getRequestURL().toString();	//��ü URL ������
		String mapping = request.getServletPath();	//���� �̸� ������
		String uri = request.getRequestURI();	//URI ������
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet3</title>");
		out.print("</head>");
		out.print("<body bgcolor='red'>");
		out.print("<b>TestServlet3�Դϴ�.</b><br>");
		out.print("<b>���ؽ�Ʈ�� : " + context + "</b><br>");
		out.print("<b>��ü��� : " + url + "</b><br>");
		out.print("<b>���θ� : " + mapping + "</b><br>");
		out.print("<b>URI : " + uri + "</b><br>");
		out.print("</body>");
		out.print("</html>");
	}

}