package com.studentfeedback.service;

import java.util.Map;

public interface FeedbackAnalyticsService {
    /**
     * Generates comprehensive analytics for submitted feedbacks
     * 
     * @return Map containing various feedback analytics
     */
    Map<String, Object> generateFeedbackAnalytics();
}