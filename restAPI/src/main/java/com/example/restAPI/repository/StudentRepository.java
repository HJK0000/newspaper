package com.example.restAPI.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.restAPI.dto.StudentDto;

@Repository
public class StudentRepository {

	private static Map<Long, StudentDto> store = new HashMap<>();
	private static long sequence = 0l;

	public void save(StudentDto studentDto) {
		studentDto.setId(++sequence);
		store.put(studentDto.getId(), studentDto);
	}

	public Optional<StudentDto> findById(Long studentId) {
		return Optional.ofNullable(store.get(studentId));
	}
}