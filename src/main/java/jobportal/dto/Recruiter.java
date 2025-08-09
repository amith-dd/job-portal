package jobportal.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String orgName;
	private String orgAbout;
	private String password;
	private String orgWebSite;
	private long EmpCount;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Job> jobs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgAbout() {
		return orgAbout;
	}
	public void setOrgAbout(String orgAbout) {
		this.orgAbout = orgAbout;
	}
	public String getOrgWebSite() {
		return orgWebSite;
	}
	public void setOrgWebSite(String orgWebSite) {
		this.orgWebSite = orgWebSite;
	}
	public long getEmpCount() {
		return EmpCount;
	}
	public void setEmpCount(long empCount) {
		EmpCount = empCount;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
	public Recruiter(String orgName, String orgAbout, String password, String orgWebSite, long empCount,
			List<Job> jobs) {
		super();
		this.orgName = orgName;
		this.orgAbout = orgAbout;
		this.password = password;
		this.orgWebSite = orgWebSite;
		EmpCount = empCount;
		this.jobs = jobs;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Recruiter() {
		super();
	}
	
	
}
