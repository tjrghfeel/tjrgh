<%@page contentType="text/html; charset=UTF-8"%>
<%
	String inputID=request.getParameter("id");
	String inputPW=request.getParameter("pw");
	
	//입력한 id가 이미있을경우
	if(application.getAttribute(inputID)!=null){
		System.out.println("해당 id가 이미 존재합니다");
		RequestDispatcher dispatcher=request.getRequestDispatcher("joinPage");
		dispatcher.forward(request,response);
	}
	//중복아니면, 컨텍스트 속성에 저장하여 회원가입처리.
	else{
		application.setAttribute(inputID,inputPW);
		RequestDispatcher dispatcher=request.getRequestDispatcher("loginPage");
		dispatcher.forward(request,response);
	}
%>