package toDoList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class toDoListMain extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		int listNum=0;//리스트의 번호
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		//체크박스 form으로 todolist 동적으로 출력
		Cookie cookies[]=request.getCookies();
		if(cookies==null){//쿠키가 존재하지않으면
			out.println("<h1>현재 할일 목록이 없습니다.</h1>");
		}
		else{//쿠키가 있다면, 반복문으로 쿠키값들 체크박스형태로 출력.
			out.println("	<form action=\"listAction\" method=\"POST\">");
			for(int i=0;i<cookies.length-1;i++){
				out.println("		<input type=\"checkbox\" name=\""+""+(listNum++)+"\" value=\""+cookies[i].getName()+"\">"+cookies[i].getValue()+"<br>");
			}
			out.println("		<input type=\"submit\" value=\"완료\">");
			out.println("	</form>");
		}
		//새로운 리스트 추가하는 부분
		out.println("	<form action=\"listAdd\" method=\"POST\">");
		out.println("		새 할일 목록 : <input type=\"text\" size=\"50\" name=\"newList\"><br>");
		out.println("		<input type=\"submit\" value=\"추가하기\">");
		out.println("	</form>");
		
		//목록 초기화
		out.println("	<form action=\"deleteList\" method=\"POST\">");
		out.println("		<input type=\"submit\" value=\"초기화\">");
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
