package com.example.restAPI.dto;

import lombok.Data;

@Data
public class StudentDto {

	private Long id;
	private String name;
	private String dept;

	public void Student(String name, String dept) {
		this.name = name;
		this.dept = dept;
		
		
	}
}
