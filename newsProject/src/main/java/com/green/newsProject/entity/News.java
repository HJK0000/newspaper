package com.green.newsProject.entity;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.ModelMapper;

import com.green.newsProject.dto.NewsDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nid;
	
	private String title;
	private String content;
	//private String writer;
	@ManyToOne
	@JoinColumn(name = "email", nullable = false)
	private User user;
	
	@Column(name = "created_at", updatable = false, nullable = false)
	@ColumnDefault("now()") // default = now()
	private LocalDateTime created_at; //@Temporal을 사용하여 Date 타입의 날짜 데이터를 매핑한다.
	//DATE는 날짜 TIME은 시간 TIMESTAMP는 날짜와 시간을 출력한다.
	
	@Column(name = "modified_at", updatable = false, nullable = false)
	@ColumnDefault("now()") // default = now()
	private LocalDateTime modified_at;
	
	@Column(name = "origin_name", length = 100, nullable = true)
	private String origin_name;
	@Column(name = "newName", length = 100, nullable = true)
	private String newName;
	@Column(name = "thumbnailName", length = 100, nullable = true)
	private String thumbnailName;
	
	private String img_content;
	
	// gradle에 추가해야 import 가능
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static NewsDto of(News news) {
		
		return modelMapper.map(news, NewsDto.class);
	}

	
}
