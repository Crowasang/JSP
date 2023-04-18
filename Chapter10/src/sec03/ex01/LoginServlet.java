package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���� �� ���ڵ� �۾� ���� - Filter�� ó��
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//getParameter() �޼��带 �̿��Ͽ� ���۵� ȸ�� ������ �����´�.
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		
		//�������� ��� ���
		String data = "�ȳ��ϼ���!<br> " + user_name + "�� ȯ���մϴ�.<br><br>";
		data += "<html><body>";
		data += "���̵� : " + user_name + "<br>";
		data += "��й�ȣ : " + user_pw + "<br>";
		data += "</body></htlm>";
		
		out.print(data);
	}

}
