package noName;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//회원정보는 가입하면 servletcontext에 저장.
//로그인시 이와 일치하면 로그인처리. 정보를 세션에 저장.
//
public class servlet1 extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>메인 게시판</title></head>");
		out.println("<body>");
		out.println("<form action=\"login\" method=\"POST\">");
		out.println("	<input type=\"submit\" value=\"로그인\">");
		out.println("</form>");
		out.println("<h1>게시판 목록</h1><br>");
		out.println("<table>");
		out.println("	<tr>");
		out.println("		<th>번호</th>");
		out.println("		<th>제목</th>");
		out.println("		<th>작성자</th>");
		out.println("		<th>시간</th>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>  a </td>");
		out.println("		<td>  b </td>");
		out.println("		<td>  c </td>");
		out.println("	</tr>");
		out.println("</table>");
		out.println("<form action=\"   \" method=\"   \">");
		out.println("	<input type=\"submit\" value=\"글쓰기\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}