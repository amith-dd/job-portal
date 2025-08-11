package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobportal.dao.MyDao;
import jobportal.dto.Job;
import jobportal.dto.Recruiter;

@WebServlet("/addjob")
public class RecruiterAddJob extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch job data from form
		String designation = req.getParameter("designation");
		double salary = Double.parseDouble(req.getParameter("salary"));
		String experience = req.getParameter("experience");
		String location = req.getParameter("location");
		String skill = req.getParameter("skill");
		//get recruiter data from session
		Recruiter recruiter = (Recruiter) req.getSession().getAttribute("sessiondata");
		//create job from form-data
		Job job = new Job(designation, salary, experience, location, skill, null);
		//create job with MyDao method
		MyDao.createJob(recruiter.getId(), job);
		//render recruiterhome.jsp after adding one job
		req.setAttribute("recruiterjobs", recruiter.getJobs());
		req.getRequestDispatcher("recruiterhome.jsp").forward(req, resp);
		
		
	}
	
}
