package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.model.dao.MemberDao;
import com.ssafy.happyhouse.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public Member login(String ID, String PW) throws Exception {
		return dao.login(ID, PW);
	}
	
	@Override
	public void signin(Member member) throws Exception {
		dao.signin(member);
	}
	
	@Override
	public void memberUpdate(Member member) throws Exception {
		dao.memberUpdate(member);
	}
	
	@Override
	public void delete(String ID, String PW) throws Exception {
		dao.delete(ID, PW);
	}

}
