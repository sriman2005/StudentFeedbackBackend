package com.studentfeedback.repository;

import com.studentfeedback.dto.InstructorAnalyticsDTO;
import com.studentfeedback.model.InstructorFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorFeedbackRepository extends JpaRepository<InstructorFeedback, Long> {
    // Custom query to get analytics for a specific instructor
    @Query("SELECT " +
            "new com.studentfeedback.dto.InstructorAnalyticsDTO(" +
            "f.instructorName, " +
            "AVG(f.rating) as overallRating, " +
            "COUNT(f) as totalFeedbackResponses, " +
            "SUM(CASE WHEN f.rating = 5 THEN 1 ELSE 0 END) as excellentRatingsCount, " +
            "SUM(CASE WHEN f.rating = 4 THEN 1 ELSE 0 END) as goodRatingsCount, " +
            "SUM(CASE WHEN f.rating = 3 THEN 1 ELSE 0 END) as averageRatingsCount, " +
            "SUM(CASE WHEN f.rating = 2 THEN 1 ELSE 0 END) as fairRatingsCount, " +
            "SUM(CASE WHEN f.rating = 1 THEN 1 ELSE 0 END) as poorRatingsCount, " +
            "AVG(f.materialExplanationRating) as materialExplanationRating, " +
            "AVG(f.objectivesClarityRating) as objectivesClarityRating, " +
            "AVG(f.contentRelevanceRating) as contentRelevanceRating, " +
            "AVG(f.assignmentClarityRating) as assignmentClarityRating, " +
            "AVG(f.gradingCriteriaRating) as gradingCriteriaRating) " +
            "FROM InstructorFeedback f " +
            "GROUP BY f.instructorName")
    List<InstructorAnalyticsDTO> findInstructorAnalytics();
}