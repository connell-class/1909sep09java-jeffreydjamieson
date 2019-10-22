package com.jamieson.model;

public class UserModel {
	private int user_id;
	private String username;
	private String user_password;
	private String fname;
	private String lname;
	private String email;
	private int user_role_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public UserModel(int user_id, String username, String user_password, String fname, String lname, String email,
			int user_role_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.user_password = user_password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "UserModel [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
				+ ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", user_role_id=" + user_role_id + "]";
	}
	
}
