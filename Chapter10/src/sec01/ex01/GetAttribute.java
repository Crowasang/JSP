package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAttribute
 */
@WebServlet("/Get")
public class GetAttribute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();
		
		//getAttribute() 메서드를 이용하여 속성이름으로 바인딩 값을 가져와 출력
		String ctxMesg = (String) ctx.getAttribute("Context");
		String sesMesg = (String) sess.getAttribute("session");
		String reqMesg = (String) request.getAttribute("request");
		
		out.print("Context값 : " + ctxMesg + "<br>");
		out.print("session값 : " + sesMesg + "<br>");
		out.print("request값 : " + reqMesg + "<br>");
	}

}
