package com.springboot.jpa.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.mvc.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	}


