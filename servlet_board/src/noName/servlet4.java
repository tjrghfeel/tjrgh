package noName;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//회원가입 처리 페이지. urlpattern은 /joinAction.
//회원가입페이지 join.html에서 입력한 정보를 받아서 ServletContext에 내용을 저장함으로서 회원가입처리.
//처리후 페이지를 로그인페이지로 돌려보냄.
public class servlet4 extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		ServletContext context=request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");
		
		//이미 저장된 같은 id가 없으면 가입페이지에서 넘어온 파라미터를 컨텍스트에 저장하여 회원가입처리.
		//이후 로그인페이지로 이동.
		if(context.getAttribute(request.getParameter("id"))==null){
			context.setAttribute(request.getParameter("id"), request.getParameter("pw"));//id와pw를 이름-값쌍으로 저장.
			RequestDispatcher dispatcher=request.getRequestDispatcher("login");
			dispatcher.forward(request,response);
		}
		//해당 id가 이미 있을경우.
		else{
			System.out.println("해당 id가 이미 있습니다!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("join.html");
			dispatcher.forward(request,response);
		}
	}

}
