package aisybestari.model;

import aisybestari.model.Staff;

public class Fulltime extends Staff {
	
	private String fixedAllowance;

	public Fulltime() {
		super();
	}	
	
	public Fulltime(String staffId, String staffUser, String staffPassword, String staffRole, String managerId, String status,String fixedAllowance) {
		super(staffId,staffUser,staffPassword,staffRole,managerId, status);
		this.fixedAllowance = fixedAllowance;
	}

	public String getFixedAllowance() {
		return fixedAllowance;
	}

	public void setFixedAllowance(String fixedAllowance) {
		this.fixedAllowance = fixedAllowance;
	}


}
