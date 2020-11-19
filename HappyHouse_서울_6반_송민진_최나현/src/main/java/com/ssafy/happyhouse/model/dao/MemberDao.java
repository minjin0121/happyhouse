package com.ssafy.happyhouse.model.dao;

import com.ssafy.happyhouse.model.dto.Member;

public interface MemberDao {
	
	public Member login(String ID, String PW) throws Exception;
	public void signin(Member member) throws Exception;
	public void memberUpdate(Member member) throws Exception;
	//public void change(String ID, String PW, String NAME, String TEL, String ADDR) throws Exception;
	public void delete(String ID, String PW) throws Exception;
	
}
