package com.studentfeedback.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "instructor_feedback")
public class InstructorFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "instructor_name", nullable = false)
    private String instructorName;

    @Column(name = "rating", nullable = false)
    private Integer rating = 0;

    @Column(name = "assignment_clarity_rating", nullable = false)
    private Integer assignmentClarityRating = 0;

    @Column(name = "content_relevance_rating", nullable = false)
    private Integer contentRelevanceRating = 0;

    @Column(name = "grading_criteria_rating", nullable = false)
    private Integer gradingCriteriaRating = 0;

    @Column(name = "material_explanation_rating", nullable = false)
    private Integer materialExplanationRating = 0;

    @Column(name = "objectives_clarity_rating", nullable = false)
    private Integer objectivesClarityRating = 0;

    @Column(name = "comment", length = 1000)
    private String comment;

    @Column(name = "additional_comments", length = 1000)
    private String additionalComments;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public InstructorFeedback() {}

    public InstructorFeedback(Long courseId, String instructorName, 
                               Integer rating,
                               Integer assignmentClarityRating,
                               Integer contentRelevanceRating,
                               Integer gradingCriteriaRating,
                               Integer materialExplanationRating,
                               Integer objectivesClarityRating,
                               String comment,
                               String additionalComments) {
        this.courseId = courseId;
        this.instructorName = instructorName;
        this.rating = rating != null ? rating : 0;
        this.assignmentClarityRating = assignmentClarityRating != null ? assignmentClarityRating : 0;
        this.contentRelevanceRating = contentRelevanceRating != null ? contentRelevanceRating : 0;
        this.gradingCriteriaRating = gradingCriteriaRating != null ? gradingCriteriaRating : 0;
        this.materialExplanationRating = materialExplanationRating != null ? materialExplanationRating : 0;
        this.objectivesClarityRating = objectivesClarityRating != null ? objectivesClarityRating : 0;
        this.comment = comment;
        this.additionalComments = additionalComments;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    // Add getters and setters for all fields
}