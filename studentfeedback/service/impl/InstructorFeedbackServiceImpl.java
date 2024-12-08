package com.studentfeedback.service.impl;

import com.studentfeedback.dto.InstructorFeedbackDTO;
import com.studentfeedback.model.Course;
import com.studentfeedback.model.InstructorFeedback;
import com.studentfeedback.repository.CourseRepository;
import com.studentfeedback.repository.InstructorFeedbackRepository;
import com.studentfeedback.service.InstructorFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructorFeedbackServiceImpl implements InstructorFeedbackService {
    @Autowired
    private InstructorFeedbackRepository instructorFeedbackRepository;

    @Autowired
    private CourseRepository courseRepository;

    
    @Override
    @Transactional
    public InstructorFeedback submitInstructorFeedback(InstructorFeedbackDTO instructorFeedbackDTO) throws Exception {
        // Calculate an overall rating (average of all specific ratings)
        Integer overallRating = calculateOverallRating(instructorFeedbackDTO);

        // Create instructor feedback entity
        InstructorFeedback instructorFeedback = new InstructorFeedback(
            instructorFeedbackDTO.getCourseId(),
            instructorFeedbackDTO.getInstructorId(),
            overallRating,
            instructorFeedbackDTO.getAssignmentClarityRating(),
            instructorFeedbackDTO.getContentRelevanceRating(),
            instructorFeedbackDTO.getGradingCriteriaRating(),
            instructorFeedbackDTO.getMaterialExplanationRating(),
            instructorFeedbackDTO.getObjectivesClarityRating(),
            instructorFeedbackDTO.getComment(),
            instructorFeedbackDTO.getAdditionalComments()
        );

        // Save instructor feedback
        return instructorFeedbackRepository.save(instructorFeedback);
    }

    private Integer calculateOverallRating(InstructorFeedbackDTO dto) {
        // Calculate average of all specific ratings
        int[] ratings = {
            dto.getAssignmentClarityRating(),
            dto.getContentRelevanceRating(),
            dto.getGradingCriteriaRating(),
            dto.getMaterialExplanationRating(),
            dto.getObjectivesClarityRating()
        };
        
        int validRatingsCount = 0;
        int totalRating = 0;
        
        for (Integer rating : ratings) {
            if (rating != null && rating > 0) {
                totalRating += rating;
                validRatingsCount++;
            }
        }
        
        return validRatingsCount > 0 ? totalRating / validRatingsCount : 0;
    }
}