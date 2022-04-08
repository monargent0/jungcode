package com.javalec.bps.dto;

import java.sql.Timestamp;

public class PDto {
	
	// Field
	int pId;
	String pName;
	String pTitle;
	Timestamp pDate;
	
	// Constructor
	public PDto() {
		
	}
	
	public PDto(int pId, String pName, String pTitle, Timestamp pDate) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pTitle = pTitle;
		this.pDate = pDate;
	}
	
	// method
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}
	
	
	
}
