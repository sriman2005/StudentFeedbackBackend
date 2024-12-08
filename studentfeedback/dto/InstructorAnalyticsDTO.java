package com.studentfeedback.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InstructorAnalyticsDTO {
    private String instructorName;
    private Double overallRating;
    private Long totalFeedbackResponses;
    private Long excellentRatingsCount;
    private Long goodRatingsCount;
    private Long averageRatingsCount;
    private Long fairRatingsCount;
    private Long poorRatingsCount;
    private Double materialExplanationRating;
    private Double objectivesClarityRating;
    private Double contentRelevanceRating;
    private Double assignmentClarityRating;
    private Double gradingCriteriaRating;

    // Constructor
    public InstructorAnalyticsDTO(
            String instructorName, 
            Double overallRating, 
            Long totalFeedbackResponses,
            Long excellentRatingsCount,
            Long goodRatingsCount,
            Long averageRatingsCount,
            Long fairRatingsCount,
            Long poorRatingsCount,
            Double materialExplanationRating,
            Double objectivesClarityRating,
            Double contentRelevanceRating,
            Double assignmentClarityRating,
            Double gradingCriteriaRating) {
        this.instructorName = instructorName;
        this.overallRating = roundDouble(overallRating);
        this.totalFeedbackResponses = totalFeedbackResponses;
        this.excellentRatingsCount = excellentRatingsCount;
        this.goodRatingsCount = goodRatingsCount;
        this.averageRatingsCount = averageRatingsCount;
        this.fairRatingsCount = fairRatingsCount;
        this.poorRatingsCount = poorRatingsCount;
        this.materialExplanationRating = roundDouble(materialExplanationRating);
        this.objectivesClarityRating = roundDouble(objectivesClarityRating);
        this.contentRelevanceRating = roundDouble(contentRelevanceRating);
        this.assignmentClarityRating = roundDouble(assignmentClarityRating);
        this.gradingCriteriaRating = roundDouble(gradingCriteriaRating);
    }

    // Utility method to round doubles
    private Double roundDouble(Double value) {
        if (value == null) return 0.0;
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    // Getters (generate all getters)
    public String getInstructorName() {
        return instructorName;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public Long getTotalFeedbackResponses() {
        return totalFeedbackResponses;
    }

    public Long getExcellentRatingsCount() {
        return excellentRatingsCount;
    }

    public Long getGoodRatingsCount() {
        return goodRatingsCount;
    }

    public Long getAverageRatingsCount() {
        return averageRatingsCount;
    }

    public Long getFairRatingsCount() {
        return fairRatingsCount;
    }

    public Long getPoorRatingsCount() {
        return poorRatingsCount;
    }

    public Double getMaterialExplanationRating() {
        return materialExplanationRating;
    }

    public Double getObjectivesClarityRating() {
        return objectivesClarityRating;
    }

    public Double getContentRelevanceRating() {
        return contentRelevanceRating;
    }

    public Double getAssignmentClarityRating() {
        return assignmentClarityRating;
    }

    public Double getGradingCriteriaRating() {
        return gradingCriteriaRating;
    }
}