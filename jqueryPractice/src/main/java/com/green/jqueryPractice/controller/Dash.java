package com.green.jqueryPractice.controller;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링 빈으로 등록하는 컴포넌트 - SERVICE, CONTROLLER, RESTCONTROLLER, REPOSITORY, MAPPER 등 - IOC
@Data 
public class Dash {
	
	private int c1;
	private int c2;
}
