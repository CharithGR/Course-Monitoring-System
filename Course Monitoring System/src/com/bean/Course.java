package com.bean;

public class Course {
	private int coursid;
	private String courseName;
	private int fee;
	private String courseDescription;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int coursid, String courseName, int fee, String courseDescription) {
		super();
		this.coursid = coursid;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}
	@Override
	public String toString() {
		return "Course [coursid=" + coursid + ", courseName=" + courseName + ", fee=" + fee + ", courseDescription="
				+ courseDescription + "]";
	}
	public int getCoursid() {
		return coursid;
	}
	public void setCoursid(int coursid) {
		this.coursid = coursid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
	
	
}
