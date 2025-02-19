package com.example.restAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restAPI.entity.Member;
import com.example.restAPI.entity.Product;
import com.example.restAPI.repository.IMemberRepository;
import com.example.restAPI.repository.IProductRepository;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private IMemberRepository imemberRepository;
	
	@Autowired
	private IProductRepository iProductRepository;
	
	@RequestMapping("/productRegist")
	public String productRegist() {

		return "productRegist";
	}

	@RequestMapping("/memberRegist")
	public String memberRegist() {

		return "memberRegist";
	}

	@GetMapping("/memberSave")
	public String getMember(Member member, Model model) {
		imemberRepository.save(member);
		model.addAttribute("member", member);
		return "memberRead"; //  Thymeleaf 템플릿 이름입니다.
	}
	
	@RequestMapping("/memberSearchAndUpdate")
	public String memberSearchAndUpdate() {
		
		return "memberSearchAndUpdate";
	}
	
	@GetMapping("/saveProduct")
	public String saveProduct(Product product, Model model) {
		
		
		iProductRepository.save(product);
		model.addAttribute("product", product);
		return "productRead";
		
	}
}
