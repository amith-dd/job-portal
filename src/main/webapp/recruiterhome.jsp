<%@page import="jobportal.dto.Job"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>recruiter</title>
</head>
<body>
<h2>Recruiter Home</h2>


<a href="recruiteraddjob.jsp">CREATE JOB</a>

<% List<Job> jobs =(List) request.getAttribute("recruiterjobs"); %>

<table border="2px">
<tr>
<th>ID</th>
<th>DESIGNATION</th>
<th>SALARY</th>
<th>EXPERIENCE</th>
<th>LOCATION</th>
<th>SKILL</th>
<th>EDIT</th>
<th>DELETE</th>
<th>VIEW APPLICATIONS</th>
</tr>



<% for(Job job : jobs){ %>

<tr>
<td><%= job.getId() %></td>
<td><%= job.getDesignation() %></td>
<td><%= job.getSalary() %></td>
<td><%= job.getExperience() %></td>
<td><%= job.getLocation() %></td>
<td><%= job.getSkill() %></td>
<td><a href="editjob">EDIT</a> </td>
<td><a href="deletejob">DELETE</a> </td>
<td><a href="viewapplications">VIEW APPLICATIONS</a> </td>
</tr>

<% } %>

</table>



</body>
</html>