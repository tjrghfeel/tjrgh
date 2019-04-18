<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.io.*" %>
<html>
	<head>
	
	</head>
	<body>
		<form action="loginPage" method="POST">
			<input type="submit" value="login">
		</form>
		<%
			File boardList=new File("C:/Users/seok ho/eclipse-workspace/jsp_board/boardList");
			if(boardList.list()==null){}
			System.out.println(boardList.list()[0]);
		%>
		<form action="writeBoard" method="POST">
			<input type="submit" value="write">
		</form>
		
		
	</body>
</html>