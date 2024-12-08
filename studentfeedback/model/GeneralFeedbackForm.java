package com.studentfeedback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "general_feedback_forms")
public class GeneralFeedbackForm {
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isHosteler() {
		return isHosteler;
	}

	public void setHosteler(boolean isHosteler) {
		this.isHosteler = isHosteler;
	}

	public String getBuildingCleanliness() {
		return buildingCleanliness;
	}

	public void setBuildingCleanliness(String buildingCleanliness) {
		this.buildingCleanliness = buildingCleanliness;
	}

	public String getClassroomCondition() {
		return classroomCondition;
	}

	public void setClassroomCondition(String classroomCondition) {
		this.classroomCondition = classroomCondition;
	}

	public String getWashroomCleanliness() {
		return washroomCleanliness;
	}

	public void setWashroomCleanliness(String washroomCleanliness) {
		this.washroomCleanliness = washroomCleanliness;
	}

	public String getWaterFacilities() {
		return waterFacilities;
	}

	public void setWaterFacilities(String waterFacilities) {
		this.waterFacilities = waterFacilities;
	}

	public String getLighting() {
		return lighting;
	}

	public void setLighting(String lighting) {
		this.lighting = lighting;
	}

	public String getVentilation() {
		return ventilation;
	}

	public void setVentilation(String ventilation) {
		this.ventilation = ventilation;
	}

	public String getCanteenCleanliness() {
		return canteenCleanliness;
	}

	public void setCanteenCleanliness(String canteenCleanliness) {
		this.canteenCleanliness = canteenCleanliness;
	}

	public String getFoodQuality() {
		return foodQuality;
	}

	public void setFoodQuality(String foodQuality) {
		this.foodQuality = foodQuality;
	}

	public String getCanteenPricing() {
		return canteenPricing;
	}

	public void setCanteenPricing(String canteenPricing) {
		this.canteenPricing = canteenPricing;
	}

	public String getCanteenVariety() {
		return canteenVariety;
	}

	public void setCanteenVariety(String canteenVariety) {
		this.canteenVariety = canteenVariety;
	}

	public String getRoomCondition() {
		return roomCondition;
	}

	public void setRoomCondition(String roomCondition) {
		this.roomCondition = roomCondition;
	}

	public String getHostelFood() {
		return hostelFood;
	}

	public void setHostelFood(String hostelFood) {
		this.hostelFood = hostelFood;
	}

	public String getHostelCleanliness() {
		return hostelCleanliness;
	}

	public void setHostelCleanliness(String hostelCleanliness) {
		this.hostelCleanliness = hostelCleanliness;
	}

	public String getHostelStaff() {
		return hostelStaff;
	}

	public void setHostelStaff(String hostelStaff) {
		this.hostelStaff = hostelStaff;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;
    private String department;
    private String year;
    private boolean isHosteler;

    // General Facilities
    private String buildingCleanliness;
    private String classroomCondition;
    private String washroomCleanliness;
    private String waterFacilities;
    private String lighting;
    private String ventilation;

    // Canteen
    private String canteenCleanliness;
    private String foodQuality;
    private String canteenPricing;
    private String canteenVariety;

    // Hostel-specific
    private String roomCondition;
    private String hostelFood;
    private String hostelCleanliness;
    private String hostelStaff;

    @Column(length = 1000)
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate = new Date();
}
