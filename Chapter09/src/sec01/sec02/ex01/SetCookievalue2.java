package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookievalue
 */
@WebServlet("/set2")
public class SetCookievalue2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date d = new Date();
		
		//Cookie ��ü�� ������ �� cookieTest �̸����� �ѱ� ������ ���ڵ��Ͽ� ��Ű�� ����
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP Programming","utf-8"));
		
		//��ȿ�Ⱓ ���� ������ �����Ͽ� session ��Ű ����.
		//������ ���� �� ����
		c.setMaxAge(-1);
		
		//������ ��Ű�� �������� ����
		response.addCookie(c);
		out.println("����ð� :" + d);
		out.println("<br> ���ڿ��� Cookie�� �����մϴ�");
		
		
	}

}
