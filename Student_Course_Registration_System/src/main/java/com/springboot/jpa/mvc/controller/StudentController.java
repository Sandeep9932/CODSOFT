package com.springboot.jpa.mvc.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.jpa.mvc.entity.Student;
import com.springboot.jpa.mvc.serviceInterface.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

//    @PostMapping("/{studentId}/register/{courseId}")
//    public Student registerCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
//        return studentService.registerCourse(studentId, courseId);
//    }

    @PostMapping("/{studentId}/drop/{courseId}")
    public Student dropCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.dropCourse(studentId, courseId);
    }
    @PostMapping("/{studentId}/register/{courseId}")
    public ResponseEntity<String> registerCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        String response = studentService.registerCourse(studentId, courseId);
        if (response.equals("Registered successfully")) {
            return ResponseEntity.ok(response);
        } else if (response.equals("Course is full")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
