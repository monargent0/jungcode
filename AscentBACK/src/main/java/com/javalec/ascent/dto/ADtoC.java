package com.javalec.ascent.dto;

import java.sql.Timestamp;

public class ADtoC {
	
	// Field
	int counselCode;
	String counselType;
	String counselTitle;
	String counselContent;
	Timestamp counselDate;
	String c_ReplyCheck;
	
	// Counstructor
	public ADtoC() {
			
	}

	public ADtoC(int counselCode, String counselType, String counselTitle, String counselContent, Timestamp counselDate,
			String c_ReplyCheck) {
		super();
		this.counselCode = counselCode;
		this.counselType = counselType;
		this.counselTitle = counselTitle;
		this.counselContent = counselContent;
		this.counselDate = counselDate;
		this.c_ReplyCheck = c_ReplyCheck;
	}

	// Method
	public int getCounselCode() {
		return counselCode;
	}

	public void setCounselCode(int counselCode) {
		this.counselCode = counselCode;
	}

	public String getCounselType() {
		return counselType;
	}

	public void setCounselType(String counselType) {
		this.counselType = counselType;
	}

	public String getCounselTitle() {
		return counselTitle;
	}

	public void setCounselTitle(String counselTitle) {
		this.counselTitle = counselTitle;
	}

	public String getCounselContent() {
		return counselContent;
	}

	public void setCounselContent(String counselContent) {
		this.counselContent = counselContent;
	}

	public Timestamp getCounselDate() {
		return counselDate;
	}

	public void setCounselDate(Timestamp counselDate) {
		this.counselDate = counselDate;
	}

	public String getC_ReplyCheck() {
		return c_ReplyCheck;
	}

	public void setC_ReplyCheck(String c_ReplyCheck) {
		this.c_ReplyCheck = c_ReplyCheck;
	}
	
	
	
	

}
