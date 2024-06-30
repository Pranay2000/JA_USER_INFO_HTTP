package com.assignment.model;

public class UserInfo {

	private String user;
    private String workstation;
    private String status;
    private String message;
    
    public UserInfo( ) {
    	
    }

    public UserInfo(String user, String workstation) {
        this.user = user;
        this.workstation = workstation;
        this.status = "Success";
        this.message = "User exists in database and has access to given workstation";
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getWorkstation() {
		return workstation;
	}

	public void setWorkstation(String workstation) {
		this.workstation = workstation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
