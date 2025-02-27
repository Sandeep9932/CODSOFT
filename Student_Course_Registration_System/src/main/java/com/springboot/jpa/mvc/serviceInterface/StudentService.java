package com.springboot.jpa.mvc.serviceInterface;

import java.util.List;

import com.springboot.jpa.mvc.entity.Student;

public interface StudentService {

	
	List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    void deleteStudent(Long id);
    String registerCourse(Long studentId, Long courseId);
    Student dropCourse(Long studentId, Long courseId);
	
	
}