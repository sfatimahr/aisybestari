package aisybestari.model;

import java.util.List;

public class Slot {
	
	private String slotId;
	private String slotTime; 
	private String slotDay;
	private String slotSeat;
	private boolean valid;
	
	private String subjectId;
	private String subjectName;
	private String fee;
	private String lvl;
	private List<Enroll_Subject> enroll_subjects;
	
	public Slot() {
		super();	
	}

	public Slot(String slotId, String slotTime, String slotDay, String slotSeat, String subjectId) {
		super();
		this.slotId = slotId;
		this.slotTime = slotTime;
		this.slotDay = slotDay;
		this.slotSeat = slotSeat;
		this.subjectId = subjectId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public String getSlotDay() {
		return slotDay;
	}

	public void setSlotDay(String slotDay) {
		this.slotDay = slotDay;
	}

	public String getSlotSeat() {
		return slotSeat;
	}

	public void setSlotSeat(String slotSeat) {
		this.slotSeat = slotSeat;
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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<Enroll_Subject> getEnroll_subjects() {
		return enroll_subjects;
	}

	public void setEnroll_subjects(List<Enroll_Subject> enroll_subjects) {
		this.enroll_subjects = enroll_subjects;
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
	
	
}
