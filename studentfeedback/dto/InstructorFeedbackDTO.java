package com.studentfeedback.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InstructorFeedbackDTO {
    @NotNull(message = "Course ID is required")
    private Long courseId;

    @NotNull(message = "Instructor name is required")
    @Size(max = 255, message = "Instructor name cannot exceed 255 characters")
    private String instructorId;

    // Add a general rating field
    private Integer rating;

    public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getAssignmentClarityRating() {
		return assignmentClarityRating;
	}

	public void setAssignmentClarityRating(Integer assignmentClarityRating) {
		this.assignmentClarityRating = assignmentClarityRating;
	}

	public Integer getContentRelevanceRating() {
		return contentRelevanceRating;
	}

	public void setContentRelevanceRating(Integer contentRelevanceRating) {
		this.contentRelevanceRating = contentRelevanceRating;
	}

	public Integer getGradingCriteriaRating() {
		return gradingCriteriaRating;
	}

	public void setGradingCriteriaRating(Integer gradingCriteriaRating) {
		this.gradingCriteriaRating = gradingCriteriaRating;
	}

	public Integer getMaterialExplanationRating() {
		return materialExplanationRating;
	}

	public void setMaterialExplanationRating(Integer materialExplanationRating) {
		this.materialExplanationRating = materialExplanationRating;
	}

	public Integer getObjectivesClarityRating() {
		return objectivesClarityRating;
	}

	public void setObjectivesClarityRating(Integer objectivesClarityRating) {
		this.objectivesClarityRating = objectivesClarityRating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	private Integer assignmentClarityRating;
    private Integer contentRelevanceRating;
    private Integer gradingCriteriaRating;
    private Integer materialExplanationRating;
    private Integer objectivesClarityRating;

    @Size(max = 1000, message = "Comment cannot exceed 1000 characters")
    private String comment;

    @Size(max = 1000, message = "Additional comments cannot exceed 1000 characters")
    private String additionalComments;

    // Constructors, getters, and setters
    // Add getters and setters for all fields
}