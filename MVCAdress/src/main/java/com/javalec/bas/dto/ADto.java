package com.javalec.bas.dto;

public class ADto {
	// aId aName aTel aAdress aEmail aRelation
	
	int aId;
	String aName;
	String aTel;
	String aAddress;
	String aEmail;
	String aRelation;
	
	public ADto() {
		
	}

	public ADto(int aId, String aName, String aTel, String aAddress, String aEmail, String aRelation) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aTel = aTel;
		this.aAddress = aAddress;
		this.aEmail = aEmail;
		this.aRelation = aRelation;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaTel() {
		return aTel;
	}

	public void setaTel(String aTel) {
		this.aTel = aTel;
	}

	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaRelation() {
		return aRelation;
	}

	public void setaRelation(String aRelation) {
		this.aRelation = aRelation;
	}
	
	

}
