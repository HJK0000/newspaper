package com.green.restApiEx.dto;

import lombok.Data;

@Data
public class MemoDto {
	
	private Integer mno;
	private String title;
	private String content;
	private String writer;
}
