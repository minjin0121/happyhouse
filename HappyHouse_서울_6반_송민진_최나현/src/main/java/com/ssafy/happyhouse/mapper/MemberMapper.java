package com.ssafy.happyhouse.mapper;

import com.ssafy.happyhouse.model.dto.Member;

public interface MemberMapper {
	
	public Member login(String ID, String PW) throws Exception;
	public void signin(Member member) throws Exception;
	public void memberUpdate(Member member) throws Exception;
	public void delete(String ID, String PW) throws Exception;
	
}
