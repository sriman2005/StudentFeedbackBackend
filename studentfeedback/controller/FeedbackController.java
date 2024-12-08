package com.studentfeedback.controller;

import com.studentfeedback.dto.FeedbackDTO;
import com.studentfeedback.model.Feedback;
import com.studentfeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<?> submitFeedback(@jakarta.validation.Valid @RequestBody FeedbackDTO feedbackDTO) {
        try {
            Feedback submittedFeedback = feedbackService.submitFeedback(feedbackDTO);
            return new ResponseEntity<>(submittedFeedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}