package com.green.newsProject.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NewsDto {

	private String title;
	private String content;
	private MultipartFile file;
	private String img_content;

	public String getFileName() {

		return file.getOriginalFilename();
	}

}
