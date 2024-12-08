package com.studentfeedback.repository;

import com.studentfeedback.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom query methods can be added here if needed
    boolean existsByCourseCode(String courseCode);
    
    // Method to fetch all courses
    List<Course> findAll();
}