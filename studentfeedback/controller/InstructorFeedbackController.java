package com.studentfeedback.controller;

import com.studentfeedback.dto.InstructorFeedbackDTO;
import com.studentfeedback.model.InstructorFeedback;
import com.studentfeedback.service.InstructorFeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructor-feedback")
public class InstructorFeedbackController {
    @Autowired
    private InstructorFeedbackService instructorFeedbackService;

    @PostMapping
    public ResponseEntity<?> submitInstructorFeedback(
        @Valid @RequestBody InstructorFeedbackDTO instructorFeedbackDTO) {
        try {
            InstructorFeedback createdFeedback = 
                instructorFeedbackService.submitInstructorFeedback(instructorFeedbackDTO);
            return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Optional: Add a method to retrieve instructor feedback if needed
    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getInstructorFeedbackByCourse(@PathVariable Long courseId) {
        // Implement logic to fetch instructor feedback for a specific course
        // This is just a placeholder - you'll need to add a corresponding method 
        // in the service and repository layers
        return ResponseEntity.ok().build();
    }
}