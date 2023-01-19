package com.bean;

public class BatchDetails {
	private int batchId;
	private int courseId;
	private int facultyId;
	private int numberofStudents;
	private String batchstartDate;
	private int duration;
	private String facultyName;
	private String courseName;
	public BatchDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BatchDetails(int batchId, int courseId, int facultyId, int numberofStudents, String batchstartDate,
			int duration, String facultyName, String courseName) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
		this.facultyName = facultyName;
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "BatchDetails [batchId=" + batchId + ", courseId=" + courseId + ", facultyId=" + facultyId
				+ ", numberofStudents=" + numberofStudents + ", batchstartDate=" + batchstartDate + ", duration="
				+ duration + ", facultyName=" + facultyName + ", courseName=" + courseName + "]";
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getNumberofStudents() {
		return numberofStudents;
	}
	public void setNumberofStudents(int numberofStudents) {
		this.numberofStudents = numberofStudents;
	}
	public String getBatchstartDate() {
		return batchstartDate;
	}
	public void setBatchstartDate(String batchstartDate) {
		this.batchstartDate = batchstartDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
