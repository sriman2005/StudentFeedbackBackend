package com.studentfeedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentfeedback.model.GeneralFeedbackForm;
import com.studentfeedback.service.GeneralFeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class GeneralFeedbackController {

    @Autowired
    private GeneralFeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<GeneralFeedbackForm> submitFeedback(@RequestBody GeneralFeedbackForm feedback) {
        GeneralFeedbackForm savedFeedback = feedbackService.submitFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneralFeedbackForm>> getAllFeedback() {
        List<GeneralFeedbackForm> feedbacks = feedbackService.getAllFeedback();
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralFeedbackForm> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<GeneralFeedbackForm>> getFeedbackByDepartment(@PathVariable String department) {
        List<GeneralFeedbackForm> feedbacks = feedbackService.getFeedbackByDepartment(department);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/hosteler/{isHosteler}")
    public ResponseEntity<List<GeneralFeedbackForm>> getFeedbackByHosteler(@PathVariable boolean isHosteler) {
        List<GeneralFeedbackForm> feedbacks = feedbackService.getFeedbackByHosteler(isHosteler);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<GeneralFeedbackForm>> getFeedbackByStudentId(@PathVariable String studentId) {
        List<GeneralFeedbackForm> feedbacks = feedbackService.getFeedbackByStudentId(studentId);
        return ResponseEntity.ok(feedbacks);
    }
}
