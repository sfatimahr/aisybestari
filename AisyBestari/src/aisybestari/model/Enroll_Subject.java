package aisybestari.model;

public class Enroll_Subject {
	
	private String enrollId;
	private String subjectId;
	private String slotId;
	public boolean valid;
	
	private Subject subject;
	
	public Enroll_Subject() {
		super();
	}

	public Enroll_Subject(String enrollId, String subjectId, String slotId) {
		super();
		this.enrollId = enrollId;
		this.subjectId = subjectId;
		this.slotId = slotId;
	}

	public String getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(String enrollId) {
		this.enrollId = enrollId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
