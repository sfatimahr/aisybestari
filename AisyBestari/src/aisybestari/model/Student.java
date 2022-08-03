package aisybestari.model;

public class Student {
	
	private String studId;
	private String studName;
	private String age;
	private String address;
	private String contact;
	private String email;
	private String studUser;
	private String studPassword;
	private boolean valid;
	
	public Student() {
		super();
	}

	public Student(String studId, String studName, String age, String address, String contact, String email, String studUser, String studPassword) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.age = age;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.studUser = studUser;
		this.studPassword = studPassword;
	}

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStudPassword() {
		return studPassword;
	}

	public void setStudPassword(String studPassword) {
		this.studPassword = studPassword;
	}

	public String getStudUser() {
		return studUser;
	}

	public void setStudUser(String studUser) {
		this.studUser = studUser;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
