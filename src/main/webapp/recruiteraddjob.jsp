<%@page import="jobportal.dto.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% HttpSession sess = request.getSession();
Recruiter recruit = (Recruiter)sess.getAttribute("sessiondata");%>
<% if(recruit!=null){ %>

<h3><%= recruit.getOrgName() %></h3>

<% } %>
<form action="addjob">
DESIGNATION:<input type="text" name="designation"><br>
SALARY:<input type="text" name="salary"><br>
EXPERIENCE:<input type="text" name="experience"><br>
LOCATION:<input type="text" name="location"><br>
SKILL:<input type="text" name="skill"><br>
<input type="submit" value="ADD JOB"><br>
</form>

</body>
</html>