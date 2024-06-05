package com.green.restApiEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MyController {

	@RequestMapping("/index2")
	public String index_fetch() {
		
		return "index2";
				
	}
	
}
