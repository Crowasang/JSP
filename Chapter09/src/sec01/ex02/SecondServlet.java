package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.print("<html><body>");
		
		// login2 서블릿에서 전송한 ID 정보를 체크하여 로그인 상태를 유지한다.
		if(user_id != null && user_id.length() != 0) {
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번재 서블릿에서 넘겨준 아이디 : " + user_id + "<br>");
			out.println("첫 번재 서블릿에서 넘겨준 비밀번호 : " + user_pw + "<br>");
			out.println("첫 번재 서블릿에서 넘겨준 주소 : " + user_address + "<br>");
			out.println("</body></html>");
		}
		else {
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인 하세요!!<br><br>");
			out.println("<a href='/Chapter09/login2.html'>로그인창으로 이동하기</a>");
		}
	}

}
