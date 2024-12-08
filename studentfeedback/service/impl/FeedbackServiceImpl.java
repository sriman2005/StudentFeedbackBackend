package com.studentfeedback.service.impl;

import com.studentfeedback.dto.FeedbackDTO;
import com.studentfeedback.model.Course;
import com.studentfeedback.model.Feedback;
import com.studentfeedback.repository.CourseRepository;
import com.studentfeedback.repository.FeedbackRepository;
import com.studentfeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public Feedback submitFeedback(FeedbackDTO feedbackDTO) throws Exception {
        // Find the course
        Course course = courseRepository.findById(feedbackDTO.getCourseId())
            .orElseThrow(() -> new Exception("Course not found"));

        // Create feedback entity
        Feedback feedback = new Feedback(
            course,
            feedbackDTO.getRating(),
            feedbackDTO.getComment()
        );

        // Save feedback
        return feedbackRepository.save(feedback);
    }
}