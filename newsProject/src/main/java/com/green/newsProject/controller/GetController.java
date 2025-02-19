package com.green.newsProject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.newsProject.entity.User;
import com.green.newsProject.repository.UserRepository;


@RestController
@RequestMapping("/get")
public class GetController {

	@Autowired
	public UserRepository userRepository;
	
	@GetMapping("/usernameChk")
	public String getEmail(@RequestParam("username") String username) {

		System.out.println("getEmail..... username : " + username);

		Optional<User> result = userRepository.findById(username);
		
		System.out.println(result);
		if (result.isPresent()) { // result에 값이 있으면

			return "해당 이메일이 이미 존재합니다";
		
		} else {

			return "사용가능한 이메일입니다";
		}

	}
}
