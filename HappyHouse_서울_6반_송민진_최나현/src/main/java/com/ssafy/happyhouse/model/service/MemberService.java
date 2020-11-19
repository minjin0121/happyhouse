package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.Member;

public interface MemberService {
	
	public Member login(String ID, String PW) throws Exception;
	public void signin(Member member) throws Exception;
	public void memberUpdate(Member member) throws Exception;
//	Member memberView(String ID) throws Exception;
//	void change(String ID, String PW, String NAME, String TEL, String ADDR) throws Exception;
	public void delete(String ID, String PW) throws Exception;
	
}
