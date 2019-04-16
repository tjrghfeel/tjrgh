package toDoList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class deleteList extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		Cookie cookies[]=request.getCookies();
		for(int i=0;i<cookies.length;i++){
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
		
		response.sendRedirect("toDoList");
	}
}
