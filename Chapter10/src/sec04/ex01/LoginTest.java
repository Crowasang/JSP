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
 * Servlet implementation class LoginTest
 */
@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���� �� ���ڵ� �۾� ���� - Filter�� ó��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//getParameter() �޼��带 �̿��Ͽ� ���۵� ȸ�� ������ �����´�.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		// �̺�Ʈ �ڵ鷯�� ������ �� ���ǿ� ����.
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			//������ ���ε� �� �̸� HttpSessionBindingListener�� ������
			//LoginImpl�� valueBound() �޼ҵ� ȣ��
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html><head>");
		out.print("<script type='text/javascript'>");
		//�ڹٽ�ũ��Ʈ�� setTimeout() �Լ��� 5�ʸ��� ������ ���û�Ͽ� �����ڼ� ǥ��
		out.print("setTimeout('history.go(0);', 5000)");
		out.print("</script>");
		out.print("</head>");
		
		out.print("<body>");
		out.print("���̵� : " + loginUser.user_id + "<br>");
		out.print("�� �����ڼ� : " + LoginImpl.total_user + "<br>");
		out.print("</body></html>");
	}

}
