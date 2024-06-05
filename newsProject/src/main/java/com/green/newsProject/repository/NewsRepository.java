package com.green.newsProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.newsProject.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
