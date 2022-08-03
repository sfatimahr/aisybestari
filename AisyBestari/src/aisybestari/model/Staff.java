package aisybestari.model;

public class Staff {
	
	private String staffId;
	private String staffUser;
	private String staffPassword;	
	private String staffRole;
	private String managerId;
	private Staff manager;
	private String status;
	private boolean valid;
	
	public Staff() {
		super();	
	}

	public Staff(String staffId, String staffUser, String staffPassword, String staffRole, String managerId,
			String status) {
		super();
		this.staffId = staffId;
		this.staffUser = staffUser;
		this.staffPassword = staffPassword;
		this.staffRole = staffRole;
		this.managerId = managerId;
		this.status = status;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffUser() {
		return staffUser;
	}

	public void setStaffUser(String staffUser) {
		this.staffUser = staffUser;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getStaffRole() {
		return staffRole;
	}

	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Staff getManager() {
		return manager;
	}

	public void setManager(Staff manager) {
		this.manager = manager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}

