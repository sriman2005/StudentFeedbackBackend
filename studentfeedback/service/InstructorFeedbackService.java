package com.studentfeedback.service;

import com.studentfeedback.dto.InstructorFeedbackDTO;
import com.studentfeedback.model.InstructorFeedback;

public interface InstructorFeedbackService {
    InstructorFeedback submitInstructorFeedback(InstructorFeedbackDTO instructorFeedbackDTO) throws Exception;
}