package com.green.jqueryPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.jqueryPractice.dto.MemberDto;
import com.green.jqueryPractice.entity.Member;
import com.green.jqueryPractice.repository.MemberRepository;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;

	@PostMapping("/member")
	public Member postMember(@RequestBody MemberDto memberDto) {
		System.out.println("postMember....... memberDto : " + memberDto);

		Member member = new Member();
		member.setName(memberDto.getName());
		member.setHobby(memberDto.getHobby());
		member.setAddr(memberDto.getAddr());
		member.setEmail(memberDto.getEmail());

		Member result = memberRepository.save(member);

		return result;

	}

	@GetMapping("/emailChk")
	public String getEmail(@RequestParam("email") String email) {

		System.out.println("getEmail..... email : " + email);

		int result = memberRepository.findByEmail(email);

		if (result > 0) {

			return "해당 이메일이 이미 존재합니다";
		} else {

			return "사용가능한 이메일입니다";
		}

	}
}
