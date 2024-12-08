package com.studentfeedback.controller;

import com.studentfeedback.dto.InstructorAnalyticsDTO;
import com.studentfeedback.service.InstructorAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faculty-feedback-analytics")
public class InstructorAnalyticsController {
    @Autowired
    private InstructorAnalyticsService instructorAnalyticsService;

    @GetMapping
    public ResponseEntity<List<InstructorAnalyticsDTO>> getInstructorAnalytics() {
        List<InstructorAnalyticsDTO> analytics = instructorAnalyticsService.getInstructorAnalytics();
        return ResponseEntity.ok(analytics);
    }
}