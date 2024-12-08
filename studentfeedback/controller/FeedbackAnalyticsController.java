package com.studentfeedback.controller;

import com.studentfeedback.service.FeedbackAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/feedback/analytics")
public class FeedbackAnalyticsController {

    @Autowired
    private FeedbackAnalyticsService feedbackAnalyticsService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getFeedbackAnalytics() {
        Map<String, Object> analytics = feedbackAnalyticsService.generateFeedbackAnalytics();
        return ResponseEntity.ok(analytics);
    }
}