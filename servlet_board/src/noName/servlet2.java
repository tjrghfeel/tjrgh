package noName;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//로그인 페이지. urlpattern은 /login.
public class servlet2 extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>로그인 페이지</title></head>");
		out.println("<body>");
		out.println("	<form action=\"loginAction\" method=\"POST\">");
		out.println("		id : <input type=\"text\" name=\"id\"><br>");
		out.println("		pw : <input type=\"text\" name=\"pw\"><br>");
		out.println("		<input type=\"submit\" value=\"login\">");
		out.println("	</form>");
		out.println("	<form action=\"join.html\" mothod=\"POST\">");
		out.println("		<input type=\"submit\" value=\"join\">");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}