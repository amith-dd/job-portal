<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="applicantsignin" method="post">
	
		EMAIL:<input type="text" name="email"><br>
		PASSWORD:<input type="text" name="password"><br>
		<input type="submit" ><br>
	</form>
	
	<% String message = (String)  request.getAttribute("message"); %>
<% if(message!=null){ %>
<h5><%= message %></h5>
<% } %>
	
</body>
</html>