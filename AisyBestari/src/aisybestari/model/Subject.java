package aisybestari.model;

public class Subject {
	
	private String subjectId;
	private String subjectName;
	private String lvl;
	private String fee;
	private boolean valid;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String subjectId, String subjectName, String lvl, String fee) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.lvl = lvl;
		this.fee = fee;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
