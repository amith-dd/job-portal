package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jobportal.dao.MyDao;
import jobportal.dto.Applicant;

@WebServlet("/applicantsignin")
public class ApplicantSignin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Applicant applicant = MyDao.applicantLogin(email, password);
		if(applicant!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("sessiondata", applicant);
			req.setAttribute("jobs", MyDao.getalljobs());
			req.getRequestDispatcher("applicanthome.jsp").forward(req, resp);
		}else{
			req.setAttribute("message", "invalid credentials");
			req.getRequestDispatcher("applicanthome.jsp").forward(req, resp);
		}

	}

}
