package com.green.jqueryPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	String[] msgs = {"hello", "hi", "안녕", "니하오"};
	int i = 0;
	
//	@RequestMapping("/")
//	public String root() {
//
//		return "redirect:/ajaxex";
//	}
	
	@RequestMapping("/ajaxex")
	public String ajaxex(Model model) {
		
		if(i > 3) {
			i = 0;
		}
		
		model.addAttribute("greet", msgs[i++]);
		return "ajaxex";
	}
	
	@RequestMapping("/index2")
	public String index_fetch() {
		
		return "index2";
				
	}
}
