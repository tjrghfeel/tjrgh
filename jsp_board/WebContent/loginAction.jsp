<%@page contentType="text/html; charset=UTF-8"%>
<%
	//form으로 받은 인자를 inputID, inputPW로 저장
	String inputID=request.getParameter("id");
	String inputPW=request.getParameter("pw");
	
	//iputID에 해당하는 회원id가없을경우
	if(application.getAttribute(inputID)==null){
		System.out.println("해당 id가 없습니다");
		RequestDispatcher dispatcher=request.getRequestDispatcher("loginPage");
		dispatcher.forward(request,response);
	}
	//inputID는 있으나 pw와 다른경우
	else if(!(inputPW.equals(application.getAttribute(inputID)))){
		System.out.println("pw가 다릅니다");
		RequestDispatcher dispatcher=request.getRequestDispatcher("loginPage");
		dispatcher.forward(request,response);
	}
	//id와 pw가 맞는경우, 세션에 id, pw라는 이름으로 아이디아 비번 저장해줌으로서 로그인처리.
	else if(inputPW.equals(application.getAttribute(inputID))){
		session.setAttribute("id",inputID);
		session.setAttribute("pw",inputPW);
		
		//다시 메인페이지로 돌려보내줌
		RequestDispatcher dispatcher=request.getRequestDispatcher("mainPage");
		dispatcher.forward(request,response);
	}
%>