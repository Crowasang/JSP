package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/*")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();	//context 이름 가져옴
		String url = request.getRequestURL().toString();	//전체 URL 가져옴
		String mapping = request.getServletPath();	//매핑 이름 가져옴
		String uri = request.getRequestURI();	//URI 가져옴
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Test Servlet4</title>");
		out.print("</head>");
		out.print("<body bgcolor='pink'>");
		out.print("<b>TestServlet4입니다.</b><br>");
		out.print("<b>컨텍스트명 : " + context + "</b><br>");
		out.print("<b>전체경로 : " + url + "</b><br>");
		out.print("<b>매핑명 : " + mapping + "</b><br>");
		out.print("<b>URI : " + uri + "</b><br>");
		out.print("</body>");
		out.print("</html>");
	}

}
