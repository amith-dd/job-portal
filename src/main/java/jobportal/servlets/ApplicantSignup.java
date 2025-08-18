package jobportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobportal.dao.MyDao;
import jobportal.dto.Applicant;

@WebServlet("/applicantsignup")
public class ApplicantSignup extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String city =  req.getParameter("city");
		long contact  =  Long.parseLong(req.getParameter("contact"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String skills = req.getParameter("skill");
		
		Applicant applicant = new Applicant(name, city, contact, email, password, skills);
		MyDao.Applicantsignup(applicant);
		
		resp.sendRedirect("applicantsignin.jsp");
		
	}
	
	
}
