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
		
		//getSession()을 호출하여 최초 요청 시 세션 객체를 새로 생성하거나 기존 세션을 반환
		HttpSession session = request.getSession();
									//생성된 객체 아이디 가져 옴.
		out.println("세션 아이디 : " + session.getId() + "<br>");
												//최초 세션 객체 생성 시간 가져옴.
		out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
												//세션 객채에 가장 최근에 접근한 시간 가져옴.
		out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		
		//세션 객체의 유효 시간을 가져 옴.
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		
		//최초 생성된 세션인지 판별
		if(session.isNew()) {
			out.print("새 세션이 만들어 졌습니다.");
		}
		//생성된 세션 객체를 강제로 삭제
		session.invalidate();
	}

}
