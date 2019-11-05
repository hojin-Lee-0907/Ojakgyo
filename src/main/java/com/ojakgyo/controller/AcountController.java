package com.ojakgyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ojakgyo.domain.MemberInfoVO;
import com.ojakgyo.domain.MemberVO;
import com.ojakgyo.domain.MemberLoginVO;
import com.ojakgyo.domain.MemberUpdateVO;
import com.ojakgyo.service.AcountService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("info")
@Controller
@Slf4j
public class AcountController {
	
	@Autowired
	private AcountService acountservice;
	
	//로그인 폼 요청
	@GetMapping("/board/login")
	public void loginGet() {
		log.info("로그인 폼 요청...");
	}
	
	@PostMapping("/board/login")
// login.jsp에서 넘긴 값 가지고 오기
	public String loginPost(MemberLoginVO vo, RedirectAttributes rttr, Model model) {
		log.info("로그인 요청...");
		// acountservice.Login() => MemberInfoVO 가 널이 아니라면
		MemberInfoVO info = acountservice.Login(vo);

		if (info != null) // 로그인 성공(세션 처리 HttpSession, @SessionAttributes)
		{
			model.addAttribute("info", info);
			// index.jsp 보여지게 만들어 주고
			return "redirect:/";
		} else {
			rttr.addFlashAttribute("error", "아이디나 비밀번호를 확인해주세요");
			// MemberInfoVO 널이라면 login.jsp 보여지게 만들기
			return "redirect:/board/login"; // forward(데이1터를 살릴수있다) or sendRedirect
		}
	}
	
////중복아이디 검사
//	@PostMapping("/checkId")
//	@ResponseBody //리턴하는 값이 실제 문자열임
//	public String checkId(String userId) {
//		log.info("중복 아이디 검사");
//		MemberInsertVO vo = acountservice.CheckId(userId);
//		
//		if(vo != null)
//			return "false";
//		else
//			return "true";
//	}
	
//// 회원탈퇴
//	@PostMapping("/delete")
//	public String DeletePost(MemberLoginVO vo, SessionStatus status) {
//		log.info("회원탈퇴 진행");
//
//		if (acountservice.Delete(vo)) {
//			// 세션해제
//			// redirect
//			status.setComplete();
//			return "redirect:/";
//		}
//		return "redirect:/delete";
//	}

//// 비밀번호변경
//// 비밀번호변경 폼 보여주기(changePwd.jsp)
//	@GetMapping("/changePwd")
//	public void changePwd(SessionStatus session) {
//		log.info("비밀번호 변경 폼 보여주기");
//		// 비밀번호 변경 폼 보여주기(changePwd.jsp)
//	}
//
//	@PostMapping("/changePwd")
//	public String changePwd(@SessionAttribute("info") MemberInfoVO info/* ==SessionAttribute("info") */,
//			SessionStatus session, MemberUpdateVO vo) {
//		log.info("비밀번호 변경 폼 보여주기");
//
//		// DB비밀번호 변경
//		// 현재 비밀번호, 바꿀 비밀번호 두개
//
//		// 현재 비밀번호가 일치하는지 확인
//		MemberLoginVO login = new MemberLoginVO();
//		login.setUserId(info.getUserId());
//		login.setCurrent_password(vo.getCurrent_password());
//		MemberInfoVO info2 = acountservice.Login(login);
//		// 현재 비밀번호가 맞지 않는다면 돌려보내기(changePwd.jsp)
//		if (info2 != null) {
//			// 비밀번호가 맞다면 비밀번호 변경 해주기
//			// 비밀번호 변경이 완료되면 세션해제 해주고 redirect:/login 이동
//			if (vo.isPasswordEqualConfirmPassword()) {
//				vo.setUserid(info.getUserId());
//				if (acountservice.Update(vo)) {
//					session.setComplete();
//					return "redirect:/login";
//				}
//			}
//		}
//		return "redirect:/changePwd";
//	}	
}