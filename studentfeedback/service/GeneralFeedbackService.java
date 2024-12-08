package com.studentfeedback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentfeedback.model.GeneralFeedbackForm;
import com.studentfeedback.repository.GeneralFeedbackRepository;

@Service
public class GeneralFeedbackService {

    @Autowired
    private GeneralFeedbackRepository feedbackRepository;

    public GeneralFeedbackForm submitFeedback(GeneralFeedbackForm feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<GeneralFeedbackForm> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Optional<GeneralFeedbackForm> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public List<GeneralFeedbackForm> getFeedbackByDepartment(String department) {
        return feedbackRepository.findByDepartment(department);
    }

    public List<GeneralFeedbackForm> getFeedbackByHosteler(boolean isHosteler) {
        return feedbackRepository.findByIsHosteler(isHosteler);
    }

    public List<GeneralFeedbackForm> getFeedbackByStudentId(String studentId) {
        return feedbackRepository.findByStudentId(studentId);
    }
}