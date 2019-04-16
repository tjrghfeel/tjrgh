package toDoList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class listAction extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException, ServletException{
		//체크된 항목을 완료처리해주는부분. 체크된 리스트는 해당 리스트번호를 name값으로 파라미터가 넘어오게됨.
		Cookie cookies[]=request.getCookies();
		for(int i=0;i<cookies.length-1;i++){
			//i번째 리스트목록에 체크가안되어있으면.
			if(request.getParameter(""+i)==null){System.out.println("no parameter for"+i);}
			//체크가 되어있으면, 넘어온파라미터의 값이 쿠키의 이름값이므로 해당이름과 같은 쿠키를 찾아 소멸시켜준다.
			else if(request.getParameter(""+i)!=null){
				System.out.println("there is parameter for"+i);
				for(int j=0;j<cookies.length;j++){
					if(cookies[j].getName().equals(request.getParameter(""+i))){
						cookies[j].setMaxAge(0);
						response.addCookie(cookies[j]);
					}
				}
			}
		}
		
		response.sendRedirect("toDoList");
	}
}
