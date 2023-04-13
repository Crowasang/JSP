package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/login4")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//�α��� â���� ���۵� ���̵�� ��й�ȣ�� ������ ��.'
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		//memberVO ��ü �����ϰ�, �Ӽ����� ���̵�� ��й�ȣ�� ����
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		
		//memberDAO ��ü ����
		MemberDAO dao = new MemberDAO();
		
		// memberVO�� isExisted() �޼��带 ȣ���Ͽ� memberVO�� ���ڷ� ����
		boolean result = dao.isExisted(memberVO);
		
		if(result) {
			HttpSession session = request.getSession();
			
			//isLogon �Ӽ��� true�� ���ǿ� ����.
			session.setAttribute("isLogon", true);
			//���̵�� ��й�ȣ�� ���ǿ� ����
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			
			out.print("<html><body>");
			out.print("�ȳ��ϼ��� " + user_id + "��!!!<br>");
			out.print("<a href='show'>ȸ����������</a>");
			out.print("</body></html>");
		}
		else {
			out.print("<html><body>");
			out.print("<a href='login4.html'>�ٽ� �α����ϱ�</a>");
			out.print("</body></html>");
		}
			
	}
}



