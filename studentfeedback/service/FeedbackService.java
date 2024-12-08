package com.studentfeedback.service;

import com.studentfeedback.dto.FeedbackDTO;
import com.studentfeedback.model.Feedback;

public interface FeedbackService {
    Feedback submitFeedback(FeedbackDTO feedbackDTO) throws Exception;
}