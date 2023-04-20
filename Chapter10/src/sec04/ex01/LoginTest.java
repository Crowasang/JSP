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
		//한글 전송 시 인코딩 작업 생략 - Filter로 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//getParameter() 메서드를 이용하여 전송된 회원 정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		// 이벤트 핸들러를 생성한 후 세션에 저장.
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			//세선에 바인딩 시 미리 HttpSessionBindingListener를 구현한
			//LoginImpl의 valueBound() 메소드 호출
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<html><head>");
		out.print("<script type='text/javascript'>");
		//자바스크립트의 setTimeout() 함수로 5초마다 서블릿에 재요청하여 접속자수 표시
		out.print("setTimeout('history.go(0);', 5000)");
		out.print("</script>");
		out.print("</head>");
		
		out.print("<body>");
		out.print("아이디 : " + loginUser.user_id + "<br>");
		out.print("총 접속자수 : " + LoginImpl.total_user + "<br>");
		out.print("</body></html>");
	}

}
