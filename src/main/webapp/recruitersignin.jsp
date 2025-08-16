<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="loginrecruiter" method="post">
Organization Name:<input type="text" name="orgname"><br>
Organization Password:<input type="text" name="orgpassword"><br>
<input type="submit">
</form>

<% String message = (String)  request.getAttribute("message"); %>
<% if(message!=null){ %>
<h5><%= message %></h5>
<% } %>

</body>
</html>