package com.example.restAPI.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restAPI.dto.MemberDto;
import com.example.restAPI.dto.ProductDto;
import com.example.restAPI.entity.Member;
import com.example.restAPI.repository.IMemberRepository;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	@Autowired
	public IMemberRepository iMemberRepository;
	
	
	// http://localhost:8092/api/v1/post-api/domain
	@PostMapping("/domain") // 약식으로 쓴 것
	// @RequestMapping(value = "/domain", method=RequestMethod.POST) // 정식으로 쓴 것 (너무
	// 길어서 약식으로 씀)
	public String postExample() {

		return "Hello Post Api!";

	}
	
	@PostMapping("/member0")
	public String postMember0(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("addr") String addr) {
		
		return name + ", " + email + ", " + addr; 
	}
	

	// http://localhost:8092/api/v1/post-api/member -- 파라미터는 BODY에 적어준다.
	@PostMapping("/member")
	public String postMember(@RequestBody Map<String, Object> postData) {

		StringBuilder sb = new StringBuilder(); // String으로 하면 계속 공간이 만들어지고, StringBuilder는 하나의 StringBuilder 객체에 계속
												// 이어붙여서 쓴다. --> 속도면에서 빠르다.
		postData.entrySet().forEach(map -> {

			sb.append(map.getKey() + " : " + map.getValue() + "\n");

		});

		return sb.toString();

	}

	// http://localhost:8092/api/v1/post-api/member2
	@PostMapping("/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto) {

		return memberDto.toString(); // ToString 문자열로 출력된다.
	}

	// http://localhost:8092/api/v1/post-api/member3
	@PostMapping("/member3")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) { // MemberDto 타입으로 변경하고, memberDto를 return하도록 바꾸면
																		// JSON형식으로 결과가 나온다.

		return memberDto;
	}

//	@PostMapping("/postProduct")
//	public ProductDto postProduct(@RequestBody ProductDto productDto, Model model) {
//		
//		return productDto;
//		
//		
//		
//	}

	@PostMapping("/updateMember")
	public Member updateMember(@RequestBody Member member) {
		return iMemberRepository.save(member);
	}
}
