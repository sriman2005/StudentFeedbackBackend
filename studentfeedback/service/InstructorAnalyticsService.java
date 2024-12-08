package com.studentfeedback.service;

import com.studentfeedback.dto.InstructorAnalyticsDTO;
import com.studentfeedback.repository.InstructorFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorAnalyticsService {
    @Autowired
    private InstructorFeedbackRepository instructorFeedbackRepository;

    @Transactional(readOnly = true)
    public List<InstructorAnalyticsDTO> getInstructorAnalytics() {
        return instructorFeedbackRepository.findInstructorAnalytics();
    }

    @Transactional(readOnly = true)
    public InstructorAnalyticsDTO getInstructorAnalyticsByName(String instructorName) {
        return instructorFeedbackRepository.findInstructorAnalytics()
                .stream()
                .filter(dto -> dto.getInstructorName().equals(instructorName))
                .findFirst()
                .orElse(null);
    }
}