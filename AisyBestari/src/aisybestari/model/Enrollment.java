package aisybestari.model;

import java.util.List;

public class Enrollment {
	
	private String enrollId;
	private String enrollDate;
	private String enrollStatus;
	private String staffId;
	private String totalPayment;
	private String studId;
	private String studName;
	private List<Enroll_Subject> enroll_Subjects;
	
	private boolean valid;
	
	public Enrollment() {
		super();
	}

	public Enrollment(String enrollId, String enrollDate, String enrollStatus, String staffId, String studId, String totalPayment) {
		this.enrollId = enrollId;
		this.enrollDate = enrollDate;
		this.enrollStatus = enrollStatus;
		this.staffId = staffId;
		this.studId = studId;
		this.totalPayment = totalPayment;
	}

	public String getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(String enrollId) {
		this.enrollId = enrollId;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getEnrollStatus() {
		return enrollStatus;
	}

	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public List<Enroll_Subject> getEnroll_Subjects() {
		return enroll_Subjects;
	}

	public void setEnroll_Subjects(List<Enroll_Subject> enroll_subjects) {
		this.enroll_Subjects = enroll_subjects;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

}
