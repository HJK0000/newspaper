package com.green.newsProject.entity;

import java.security.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
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
public class Accept {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;

	@OneToOne
	@JoinColumn(name = "news_id", nullable = false)
	private News news;

	private String accept; // 승인여부 (승인/반려/승인대기중)

	private String why;

	@ManyToOne
	@JoinColumn(name = "email", nullable = false)
	private User user;

	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Timestamp created_at; // @Temporal을 사용하여 Date 타입의 날짜 데이터를 매핑한다.
	// DATE는 날짜 TIME은 시간 TIMESTAMP는 날짜와 시간을 출력한다.

	@PrePersist
	protected void onCreate() {
		if (this.accept == null) {
			this.accept = "승인대기중";
		}
	}
}
