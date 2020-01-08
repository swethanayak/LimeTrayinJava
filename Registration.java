package com.deloitte.limetray.model;

public class Registration {

	private String username;
	private String userid;
	private String password;
	private long phonenumber;
	private String emailid;
	public String getUsername() {
		return username;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Registration [username=" + username + ", userid=" + userid + ", password=" + password + ", phonenumber="
				+ phonenumber + ", emailid=" + emailid + "]";
	}
	
	
	
}
