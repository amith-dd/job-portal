package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobportal.dao.MyDao;
import jobportal.dto.Recruiter;

@WebServlet("/saverecruiter")
public class RecruiterSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form data
		String orgname = req.getParameter("orgname");
		String about = req.getParameter("orgabout");
		String password = req.getParameter("orgpassword");
		String website = req.getParameter("orgwebsite");
		int empcount = Integer.parseInt(req.getParameter("orgempcount"));
		
		// form data -> Obj of Recruiter
		Recruiter recruiter = new Recruiter(orgname, about, password, website, empcount, null);
		
		// saving Recruiter
		MyDao.recruiterSignup(recruiter);
		
		// to login page aftter signup
		resp.sendRedirect("recruitersignin.jsp");
	}

}
