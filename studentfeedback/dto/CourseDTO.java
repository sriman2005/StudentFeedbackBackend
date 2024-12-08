package com.studentfeedback.dto;


public class CourseDTO {
    @jakarta.validation.constraints.NotBlank(message = "Course name is required")
    @jakarta.validation.constraints.Size(max = 255, message = "Course name cannot exceed 255 characters")
    private String courseName;

    @jakarta.validation.constraints.NotBlank(message = "Course code is required")
    @jakarta.validation.constraints.Size(max = 50, message = "Course code cannot exceed 50 characters")
    private String courseCode;

    @jakarta.validation.constraints.NotBlank(message = "Description is required")
    private String description;

    @jakarta.validation.constraints.NotBlank(message = "Department is required")
    private String department;

    @jakarta.validation.constraints.NotNull(message = "Credits are required")
    private Integer credits;

    @jakarta.validation.constraints.NotBlank(message = "Instructor name is required")
    private String instructor;

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}