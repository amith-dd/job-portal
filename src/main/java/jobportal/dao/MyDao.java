package jobportal.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jobportal.dto.Applicant;
import jobportal.dto.Application;
import jobportal.dto.Job;
import jobportal.dto.Recruiter;

public class MyDao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static void recruiterSignup(Recruiter recruiter) {
		et.begin();
		em.persist(recruiter);
		et.commit();
	}

	public static Recruiter recruiterLogin(String orgName, String password) {
		Query query = em.createQuery("select re from Recruiter re where re.orgName=?1");
		query.setParameter(1, orgName);
		Recruiter dbRecruiter = (Recruiter) query.getSingleResult();
		if (dbRecruiter != null && dbRecruiter.getPassword().equals(password)) {
			return dbRecruiter;
		}
		return null;
	}

	public static void createJob(int recruiterId, Job job) {
		Recruiter recruiter = em.find(Recruiter.class, recruiterId);
		if (recruiter.getJobs() == null) {
			List<Job> jobs = new ArrayList<Job>();
			jobs.add(job);
		} else {
			recruiter.getJobs().add(job);
		}
		et.begin();
		em.merge(recruiter);
		et.commit();
	}

	public static List<Job> findJobsByRecruiterId(int recruiterId) {
		List<Job> jobs = em.find(Recruiter.class, recruiterId).getJobs();
		return jobs;
	}
	
	public static void deleteJob(int recruiterid ,int jobid) {
		Recruiter recruiter = em.find(Recruiter.class, recruiterid);
		Job job = em.find(Job.class, jobid);
		if(recruiter.getJobs().contains(job)) {
			recruiter.getJobs().remove(job);
			et.begin();
			em.merge(recruiter);
			em.remove(job);
			et.commit();
		}
		
	}

	public static Job findJobByJobId(int jobid) {
		return em.find(Job.class, jobid);
	}

	public static void updateJob(Job job) {
		et.begin();
		em.merge(job);
		et.commit();
	}

	public static void Applicantsignup(Applicant applicant) {
		et.begin();
		em.persist(applicant);
		et.commit();
	}

	public static Applicant applicantLogin(String email, String password) {
		Query query = em.createQuery("select ap from Applicant ap where ap.email=?1");
		query.setParameter(1, email);
		Applicant applicant = (Applicant) query.getSingleResult();
		if (applicant != null && applicant.getPassword().equals(password)) {
			return applicant;
		}
		return null;
	}

	public static boolean applicantJobApply(int applicantid, int jobid) {
		Job job = em.find(Job.class, jobid);
		
		List<Application> applications = job.getApplications();
		boolean applied = true;
		for(Application application : applications) {
			if(application.getUserid()==applicantid) {
				applied=false;
			}
		}
		if(applied) {
			LocalDate date = LocalDate.now();
			String stringdate = String.valueOf(date);
			Application application = new Application(applicantid, "pending", stringdate, job.getDesignation(),
					job.getSalary(), job.getExperience(), job.getLocation(), job.getSkill());

			job.getApplications().add(application);

			et.begin();
			em.merge(job);
			et.commit();
		}
		return applied;
		
	}
	
	public static List<Application> viewApplicationsByApplicantId(int applicantid){
		Query query = em.createQuery("select app from Application app where app.applicantid=?1");
		query.setParameter(1, applicantid);
		List<Application> appls = query.getResultList();
		return appls;
	}
	
	public static List<Application> viewApplicationsByJobId(int jobId){
		return em.find(Job.class, jobId).getApplications();
	}
	
	public static List<Job> getalljobs(){
		Query query = em.createQuery("select j from Job j");
		List<Job> jobs = query.getResultList();
		return jobs;
	}

}
