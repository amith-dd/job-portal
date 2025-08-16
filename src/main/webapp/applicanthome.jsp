<%@page import="jobportal.dto.Job"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% List<Job> jobs =(List) request.getAttribute("jobs"); %>

<table border="2px">
<tr>
<th>ID</th>
<th>COMPANY</th>
<th>DESIGNATION</th>
<th>SALARY</th>
<th>EXPERIENCE</th>
<th>LOCATION</th>
<th>SKILL</th>
<th>APPLY</th>

</tr>


<% if(!jobs.isEmpty()){ %>
<% for(Job job : jobs){ %>

<tr>
<td><%= job.getId() %></td>
<td><%= job.getRecruiter().getOrgName() %></td>
<td><%= job.getDesignation() %></td>
<td><%= job.getSalary() %></td>
<td><%= job.getExperience() %></td>
<td><%= job.getLocation() %></td>
<td><%= job.getSkill() %></td>
<td><a href="apply">APPLY</a> </td>

</tr>

<% } %>
<% } %>
</table>

<a href="logout">LOGOUT</a>

</body>
</html>