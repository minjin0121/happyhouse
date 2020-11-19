package com.ssafy.happyhouse.model.dto;

public class Board {
	
	private String NUM;
	private String PASS;
	private String NAME;
	private String WDATE;
	private String TITLE;
	private String CONTENT;
	private String COUNT;
	
	public Board() {
	}

	public Board(String num, String pass, String name, String wdate, String title, String content, String count) {
		setNUM(num);
		setPASS(pass);
		setNAME(name);
		setWDATE(wdate);
		setTITLE(title);
		setCONTENT(content);
		setCOUNT(count);
	}

	public String getNUM() {
		return NUM;
	}

	public void setNUM(String num) {
		NUM = num;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pass) {
		PASS = pass;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getWDATE() {
		return WDATE;
	}

	public void setWDATE(String wdate) {
		WDATE = wdate;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String title) {
		TITLE = title;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String content) {
		CONTENT = content;
	}

	public String getCOUNT() {
		return COUNT;
	}

	public void setCOUNT(String count) {
		COUNT = count;
	}

}
