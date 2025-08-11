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


@WebServlet("/loginrecruiter")
public class RecruiterSignin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orgname = req.getParameter("orgname");
		String password = req.getParameter("orgpassword");
		
		Recruiter recruiter = MyDao.recruiterLogin(orgname, password);
		if(recruiter!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("sessiondata", recruiter);
			req.setAttribute("recruiterjobs", recruiter.getJobs());
			req.getRequestDispatcher("recruiterhome.jsp").forward(req, resp);
		}else {
			req.setAttribute("message","Invalid Credentials");
			req.getRequestDispatcher("recruitersignin.jsp").forward(req, resp);
		}
			
		
	}
	
}
