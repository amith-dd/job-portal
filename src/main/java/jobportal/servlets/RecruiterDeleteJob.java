package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobportal.dao.MyDao;
import jobportal.dto.Recruiter;


@WebServlet("/deletejob")
public class RecruiterDeleteJob extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		HttpSession session = req.getSession();
		Recruiter recruiter = (Recruiter) session.getAttribute("sessiondata");
		MyDao.deleteJob(recruiter.getId(),jobid);
		
		req.setAttribute("recruiterjobs", recruiter.getJobs());
		req.getRequestDispatcher("recruiterhome.jsp").forward(req, resp);
		
	}
	
}
