package noName;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//로그인 처리페이지. 로그인 정보를 받아서 회원이면 로그인처리를 해주고 아니면 다시 돌려보내는 페이지
//url-pattern은 /loginAction.
public class servlet3 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();
		
		//넘겨받은 id,pw값이 컨텍스트에 저장된 속성값(회원정보)과 같으면 세션에 저장하여 로그인처리를하고 메인페이지로이동
		if(context.getAttribute(request.getParameter("id"))==null){
			System.out.println("id없음");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login");
			dispatcher.forward(request,response);
		}
		else if(context.getAttribute(request.getParameter("id")).equals(request.getParameter("pw"))){
			session.setAttribute("id", request.getParameter("id"));
			session.setAttribute("pw", request.getParameter("pw"));
			System.out.println("세션저장성공");
			
			//RequestDispatcher dispatcher=request.getRequestDispatcher("BoardMain");
			//dispatcher.forward(request,response);
			//forward()로 보내는건 doGet메소드로 못받길래 그냥 sendRedirect()사용함.
			response.sendRedirect("BoardMain");
		}
		//다를경우 로그인페이지로 다시이동
		else{
			System.out.println("pw트림");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login");
			dispatcher.forward(request,response);
		}
	}
}
