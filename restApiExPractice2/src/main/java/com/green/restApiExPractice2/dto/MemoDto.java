package com.green.restApiExPractice2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MemoDto {

	private Integer mno;
	private String title;
	private String content;
	private String writer;
}
