package com.springboot.jpa.mvc.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.mvc.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

	@Query("SELECT c FROM Course c WHERE c.startDate >= :startDate AND c.endDate <= :endDate")
    List<Course> findCoursesWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    

}