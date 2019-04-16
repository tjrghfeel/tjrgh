package toDoList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//리스트 추가시켜주는 서블릿.
public class listAdd extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		//새로운 리스트입력되면 등록해주는 부분
		Cookie newList=new Cookie("1"+System.currentTimeMillis(),request.getParameter("newList"));
		newList.setMaxAge(60*60*24*7);//유효시간은 일주일.
		response.addCookie(newList);
		
		response.sendRedirect("toDoList");
	}
}
