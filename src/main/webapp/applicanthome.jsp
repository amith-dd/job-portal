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

<a href="myapplications">MY APPLICATIONS</a>

<% String message = (String) request.getAttribute("message"); %>
<% if(message!=null){ %>

<h2><%= message %></h2>

<% } %>

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
<td><a href="applyjob?jobid=<%= job.getId() %>">APPLY</a> </td>

</tr>

<% } %>
<% } %>
</table>

<a href="logout">LOGOUT</a>

</body>
</html>