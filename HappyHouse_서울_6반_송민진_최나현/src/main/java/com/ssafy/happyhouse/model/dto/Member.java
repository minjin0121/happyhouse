package com.ssafy.happyhouse.model.dto;

public class Member {
	
	private String memberID;
	private String memberPW;
	private String memberNAME;
	private String memberTEL;
	private String memberADDR;
	
	public Member() {
	}

	public Member(String memberID, String memberPW, String memberNAME, String memberTEL, String memberADDR) {
		this.memberID = memberID;
		this.memberPW = memberPW;
		this.memberNAME = memberNAME;
		this.memberTEL = memberTEL;
		this.memberADDR = memberADDR;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	public String getMemberNAME() {
		return memberNAME;
	}

	public void setMemberNAME(String memberNAME) {
		this.memberNAME = memberNAME;
	}

	public String getMemberTEL() {
		return memberTEL;
	}

	public void setMemberTEL(String memberTEL) {
		this.memberTEL = memberTEL;
	}

	public String getMemberADDR() {
		return memberADDR;
	}

	public void setMemberADDR(String memberADDR) {
		this.memberADDR = memberADDR;
	}
	
}
