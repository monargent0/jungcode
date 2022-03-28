package com.javalec.bbs.dto;

import java.sql.Timestamp;

public class BDto { 
	// DB내용 가져오는 역할. DB와 똑같이 만들어야 한다. 테이블 갯수만큼 Dto가 있어야 한다. javaBean이랑 같다
	
	// Field 테이블 컬럼이름이랑 똑같이 써라
	int bId;
	String bName;
	String bTitle;
	String bContent;
	Timestamp bDate;
	
	// Constructor
	public BDto() {

	}
	public BDto(int bId, String bName, String bTitle, String bContent, Timestamp bDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}

	//Method
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

}
