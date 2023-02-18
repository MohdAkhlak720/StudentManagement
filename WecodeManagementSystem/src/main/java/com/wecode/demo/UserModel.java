package com.wecode.demo;
public class UserModel {

	private String userName;
	private String password;
	private String email;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

}