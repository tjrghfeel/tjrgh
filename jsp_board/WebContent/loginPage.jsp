<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>login Page</title>
		<h3>로그인 페이지 입니다.</h3>
	</head>
	<body>
		<%--로그인이 이미 되어있으면 페이지를 다시 돌려보내주는 부분 --%>
		<%
			if(session.getAttribute("id")!=null){
				RequestDispatcher dispatcher= request.getRequestDispatcher("mainPage");
				dispatcher.forward(request,response);
			}
		%>
		
		<%--로그인 하는부분 --%>
		<form action="loginAction" method="POST">
			id  : <input type="text" name="id"><br>
			pw : <input type="password" name="pw">
			<input type="submit" value="login">
		</form>
		
		<%--회원가입하기 --%>
		<form action="joinPage" method="POST">
			<input type="submit" value="join">
		</form>
	</body>
</html>