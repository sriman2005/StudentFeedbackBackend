package com.studentfeedback.service;

import com.studentfeedback.dto.CourseDTO;
import com.studentfeedback.model.Course;
import java.util.List;

public interface CourseService {
    Course createCourse(CourseDTO courseDTO) throws Exception;
    
    // New method to get all courses
    List<Course> getAllCourses();
}