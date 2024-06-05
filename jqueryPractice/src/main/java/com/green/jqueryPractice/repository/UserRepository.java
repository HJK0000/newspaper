package com.green.jqueryPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jqueryPractice.entity.Member;
import com.green.jqueryPractice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
