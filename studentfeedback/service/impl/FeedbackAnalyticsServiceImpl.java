package com.studentfeedback.service.impl;

import com.studentfeedback.model.Course;
import com.studentfeedback.model.Feedback;
import com.studentfeedback.repository.CourseRepository;
import com.studentfeedback.repository.FeedbackRepository;
import com.studentfeedback.service.FeedbackAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FeedbackAnalyticsServiceImpl implements FeedbackAnalyticsService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Map<String, Object> generateFeedbackAnalytics() {
        Map<String, Object> analytics = new HashMap<>();

        // Get all feedbacks
        List<Feedback> allFeedbacks = feedbackRepository.findAll();

        // Total number of feedbacks
        analytics.put("totalFeedbacks", allFeedbacks.size());

        // Overall average rating
        double averageRating = allFeedbacks.stream()
            .mapToInt(Feedback::getRating)
            .average()
            .orElse(0.0);
        analytics.put("averageRating", averageRating);

        // Rating distribution
        Map<Integer, Long> ratingDistribution = allFeedbacks.stream()
            .collect(Collectors.groupingBy(
                Feedback::getRating, 
                Collectors.counting()
            ));
        analytics.put("ratingDistribution", ratingDistribution);

        // Course-wise feedback analytics
        List<Course> courses = courseRepository.findAll();
        List<Map<String, Object>> courseFeedbacks = courses.stream()
            .map(course -> {
                List<Feedback> courseFeedbackList = allFeedbacks.stream()
                    .filter(f -> f.getCourse().getId().equals(course.getId()))
                    .collect(Collectors.toList());

                Map<String, Object> courseFeedbackMap = new HashMap<>();
                courseFeedbackMap.put("courseName", course.getCourseName());
                courseFeedbackMap.put("totalFeedbacks", courseFeedbackList.size());
                courseFeedbackMap.put("averageRating", courseFeedbackList.stream()
                    .mapToInt(Feedback::getRating)
                    .average()
                    .orElse(0.0));

                return courseFeedbackMap;
            })
            .collect(Collectors.toList());

        analytics.put("courseFeedbacks", courseFeedbacks);

        return analytics;
    }
}