package com.javalec.ascent.dto;

import java.sql.Timestamp;

public class ADtoN {

	// Field
	int noticeCode;
	String noticeType;
	String noticeTitle;
	String noticeContent;
	Timestamp noticeDate;
	
	// Constructor
	public ADtoN() {
		
	}

	public ADtoN(int noticeCode, String noticeType, String noticeTitle, String noticeContent, Timestamp noticeDate) {
		super();
		this.noticeCode = noticeCode;
		this.noticeType = noticeType;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
	}

	// Method
	public int getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Timestamp getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	
	
	
	
}
