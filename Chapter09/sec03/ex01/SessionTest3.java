package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest1
 */
@WebServlet("/session3")
public class SessionTest3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getSession()�� ȣ���Ͽ� ���� ��û �� ���� ��ü�� ���� �����ϰų� ���� ������ ��ȯ
		HttpSession session = request.getSession();
									//������ ��ü ���̵� ���� ��.
		out.println("���� ���̵� : " + session.getId() + "<br>");
												//���� ���� ��ü ���� �ð� ������.
		out.println("���� ���� ���� �ð� : " + new Date(session.getCreationTime()) + "<br>");
												//���� ��ä�� ���� �ֱٿ� ������ �ð� ������.
		out.println("�ֱ� ���� ���� �ð� : " + new Date(session.getLastAccessedTime()) + "<br>");
		
		//���� ��ü�� ��ȿ �ð��� ���� ��.
		out.println("���� ��ȿ �ð� : " + session.getMaxInactiveInterval() + "<br>");
		
		
		//���� ������ �������� �Ǻ�
		if(session.isNew()) {
			out.print("�� ������ ����� �����ϴ�.");
		}
		//������ ���� ��ü�� ������ ����
		session.invalidate();
	}

}
