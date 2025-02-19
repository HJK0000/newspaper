package com.green.jqueryPractice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.jqueryPractice.dto.UserDto;
import com.green.jqueryPractice.entity.User;
import com.green.jqueryPractice.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class AjaxController {

	
	private Dash dash;
	private int cnt = 0;
	private int cnt2 = 0;
	
	private AjaxController(Dash dash) { // 빈으로 등록된 객체를 생성자 주입방식으로 넣음
		this.dash = dash;
	}

	private void SetDash(Dash dash) {
		
		this.dash = dash;
	}
	
	@PostMapping("/submitForm")
	public String postUser(@RequestParam Map<String, String> formData) {
		// 폼 데이터 처리로직
		cnt++;
		dash.setC1(cnt);
		String username = formData.get("username");
		String password = formData.get("password");

		return username + ", " + password;
	}
	
	

	@PostMapping("/submitJson")
	public String submitJson(@RequestBody Map<String, String> jsonData) {
		// JSON 데이터 처리 로직
		cnt2++;
		dash.setC2(cnt2);
		String username = jsonData.get("username");
		String password = jsonData.get("password");

		return "JSON submitted successfully: " + username + ", " + password;

	}

	
	@PostMapping("/submitForm2")
	public String submitForm2(@RequestBody Map<String, String> jsonData) {
		//JSON 데이터 처리 로직
		String username = jsonData.get("username");
		String password = jsonData.get("password");
		
		return "JSON 섭밋티드 석세스풀리 : " + username ;
		
		
	}
	
	
	
	@GetMapping("/randomGreeting")
	public String randomGreeting() {

		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("hole");
		list.add("안녕");
		
		return "";
		
		
	}
}
