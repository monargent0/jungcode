package com.javalec.ascent.dto;

public class ADtoU {
	String userName;
	String userGender;
	String userBirth;
	String userPhone;
	String userEmail;
	
	public ADtoU() {
		
	}

	public ADtoU(String userName, String userGender, String userBirth, String userPhone, String userEmail) {
		super();
		this.userName = userName;
		this.userGender = userGender;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
