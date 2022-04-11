package com.javalec.ascent.dto;

public class ADtoA {
	//
	int addressCode;
	String addressType;
	String postcode;
	String mainAddress;
	String detailAddress;
	String extraAddress;
	String user_userID;
	
	public ADtoA() {
		
	}

	public ADtoA(int addressCode, String addressType, String postcode, String mainAddress, String detailAddress,
			String extraAddress, String user_userID) {
		super();
		this.addressCode = addressCode;
		this.addressType = addressType;
		this.postcode = postcode;
		this.mainAddress = mainAddress;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
		this.user_userID = user_userID;
	}

	public int getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getUser_userID() {
		return user_userID;
	}

	public void setUser_userID(String user_userID) {
		this.user_userID = user_userID;
	}

	
	
}
