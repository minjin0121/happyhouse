package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssafy.happyhouse.model.dto.Member;
import com.ssafy.happyhouse.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@GetMapping("/signin")
    public String signinView() { // 회원가입 화면
		return "signin";
	}
	
	@PostMapping("/signin")
	public String signin(Member member, Model model) { // 회원가입 처리
		System.out.println("Signin Member : " + member.getMemberID() + " / " + member.getMemberPW());
		
		try{
			service.signin(member);
			return "redirect:/";
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "회원 저장에 실패했습니다.");
	        return "error/error";
		}
	}
	
	@GetMapping("/login")
    public String loginView() { // 로그인 화면
		return "loginForm";
	}
	
	@PostMapping("/login")
    public String login(String id, String pw, HttpSession session, Model model) { // 로그인 처리
		System.out.println("ID : " + id + " / PW : " + pw);
		
    	try {
    		Member member = service.login(id, pw);
    		System.out.println(member + " / " + member.getMemberNAME());
			
				model.addAttribute("msg", "정상적으로 로그인 되었습니다");
				model.addAttribute("member", member);
				session.setAttribute("memberID", id);
				session.setAttribute("memberPW", pw);
				return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 실패~~ 다시 시도해주세요");
			return "error";
		}
    }

	@GetMapping("/info")
    public String infoView(HttpSession session, Model model) { // 회원 정보 화면
		String loginID = (String) session.getAttribute("memberID");
		String loginPW = (String) session.getAttribute("memberPW");

		if (loginID != null && loginPW != null) {
			System.out.println("회원정보 삭제 화면 : " + loginID + " / " + loginPW);
			try {
				Member member = service.login(loginID, loginPW);
				System.out.println("MEMBER : " + member.getMemberNAME());
				model.addAttribute("member", member);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "memberInfo";
	}
	
	@GetMapping("/update")
	public String updateView(HttpSession session, Model model) { // 회원 정보 수정 화면
		String loginID = (String) session.getAttribute("memberID");
		String loginPW = (String) session.getAttribute("memberPW");

		if (loginID != null && loginPW != null) {
			System.out.println("회원정보 수정화면 : " + loginID + " / " + loginPW);
			try {
				Member member = service.login(loginID, loginPW);
				System.out.println("MEMBER : " + member.getMemberNAME());
				model.addAttribute("member", member);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "change";
	}
	
	@PostMapping("/update")
	public String update(Member member, Model model, HttpSession session) { // 회원 정보 수정
		try {
			service.memberUpdate(member);
			session.setAttribute("memberPW", member.getMemberPW());
			System.out.println("수정 : PW " + member.getMemberPW());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 정보 수정 실패");
			return "error";
		}
		return "index";	
	}
	
	@GetMapping("/delete")
	public String deleteView(HttpSession session, Model model) { // 회원 정보 삭제 화면
		String loginID = (String) session.getAttribute("memberID");
		String loginPW = (String) session.getAttribute("memberPW");

		if (loginID != null && loginPW != null) {
			System.out.println("회원정보 삭제 화면 : " + loginID + " / " + loginPW);
			try {
				Member member = service.login(loginID, loginPW);
				System.out.println("MEMBER : " + member.getMemberNAME());
				model.addAttribute("member", member);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "delete";
	}
	
	@PostMapping("/delete")
	public String delete(String memberID, String memberPW, Model model, HttpSession session) { // 회원 정보 삭제
		try {
			System.out.println("회원 정보 삭제 : " + memberID + " / " + memberPW);
			service.delete(memberID, memberPW);
			logout(session);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 정보 삭제 실패");
			return "error";
		}
		return "redirect:/";	
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) { // 로그아웃 처리
		session.removeAttribute("memberID");
		return "redirect:/";	
	}
}
