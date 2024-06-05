package com.green.restApiExPractice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.restApiExPractice2.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer>{

	
}
