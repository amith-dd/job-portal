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

@WebServlet("/updatejob")
public class UpdateJob extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch job data from form
		int jobid = Integer.parseInt(req.getParameter("id"));
		String designation = req.getParameter("designation");
		double salary = Double.parseDouble(req.getParameter("salary"));
		String experience = req.getParameter("experience");
		String location = req.getParameter("location");
		String skill = req.getParameter("skill");
		// get recruiter data from session
		Recruiter recruiter = (Recruiter) req.getSession().getAttribute("sessiondata");
		
		Job dbjob = MyDao.findJobByJobId(jobid);
	
		Job job = new Job(designation, salary, experience, location, skill,recruiter ,dbjob.getApplications());
		job.setId(jobid);
		MyDao.updateJob(job);
		
		// render recruiterhome.jsp after adding one job
		req.setAttribute("recruiterjobs", recruiter.getJobs());
		req.getRequestDispatcher("recruiterhome.jsp").forward(req, resp);
	}

}
