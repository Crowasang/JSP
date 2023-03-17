package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet5
 */
@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init �޼ҵ� ȣ��");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory �޼ҵ� ȣ��");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost �޼ҵ� ȣ��");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		if(id != null &&(id.length() !=0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + " ��!!! �α��� �ϼ̽��ϴ�");
			out.print("</body>");
			out.print("</html>");
		}
		else {
			out.print("<html>");
			out.print("<body>");
			out.print("���̵� �Է��ϼ���!!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8080/Chapter06/test01/login6.html'>�α��� â���� �̵�</a>");
			out.print("</body>");
			out.print("</html>");
	}

	}
}	

