package com.example.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restAPI.entity.Member;

public interface IMemberRepository extends JpaRepository<Member, Integer>{

	
}
