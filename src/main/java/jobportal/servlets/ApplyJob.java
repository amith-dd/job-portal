package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobportal.dao.MyDao;
import jobportal.dto.Applicant;

@WebServlet("/applyjob")
public class ApplyJob extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int jobid = Integer.parseInt(req.getParameter("jobid"));
		Applicant applicant = (Applicant)req.getSession().getAttribute("sessiondata");
		boolean applied = MyDao.applicantJobApply(applicant.getId(), jobid);
		String message = applied?"Applied":"already applied";
		req.setAttribute("message", message);
		req.setAttribute("jobs", MyDao.getalljobs());
		req.getRequestDispatcher("applicanthome.jsp").forward(req, resp);
	}
	
}
