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
		//한글 전송 시 인코딩 작업 생략 - Filter로 처리
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//getParameter() 메서드를 이용하여 전송된 회원 정보를 가져온다.
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		
		//브라우저로 결과 출력
		String data = "안녕하세요!<br> " + user_name + "님 환영합니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + user_name + "<br>";
		data += "비밀번호 : " + user_pw + "<br>";
		data += "</body></htlm>";
		
		out.print(data);
	}

}
