package com.springboot.jpa.mvc.serviceInterface;




import java.time.LocalDate;
import java.util.List;

import com.springboot.jpa.mvc.entity.Course;



public interface CourseService {
	
	List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
	
    List<Course> findCoursesWithinDateRange(LocalDate startDate, LocalDate endDate);
    
}