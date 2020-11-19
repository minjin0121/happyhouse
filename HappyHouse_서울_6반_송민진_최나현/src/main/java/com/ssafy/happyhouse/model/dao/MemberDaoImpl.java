package com.ssafy.happyhouse.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ssafy.happyhouse.mapper.MemberMapper;
import com.ssafy.happyhouse.model.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public Member login(String ID, String PW) throws Exception {
		return mapper.login(ID, PW);
	}
	
	@Override
	public void signin(Member member) throws Exception {
		mapper.signin(member);
	}

	@Override
	public void memberUpdate(Member member) throws Exception {
		mapper.memberUpdate(member);
	}

	@Override
	public void delete(String ID, String PW) throws Exception {
		mapper.delete(ID, PW);
	}

}
