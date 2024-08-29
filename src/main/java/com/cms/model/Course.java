package com.cms.model;



public class Course {
	private int courseid;
	private String coursename;
	private String coursedescription;
	private int courseduration;
	private String coursetrainer;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursedescription() {
		return coursedescription;
	}
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	public int getCourseduration() {
		return courseduration;
	}
	public void setCourseduration(int courseduration) {
		this.courseduration = courseduration;
	}
	public String getCoursetrainer() {
		return coursetrainer;
	}
	public void setCoursetrainer(String coursetrainer) {
		this.coursetrainer = coursetrainer;
	}
	
	
	public Course(int courseid, String coursename, String coursedescription, int courseduration, String coursetrainer) {

		this.courseid = courseid;
		this.coursename = coursename;
		this.coursedescription = coursedescription;
		this.courseduration = courseduration;
		this.coursetrainer = coursetrainer;
	}
	
	
	@Override
	public String toString() {
		return "User [courseid=" + courseid + ", coursename=" + coursename + ", coursedescription=" + coursedescription
				+ ", courseduration=" + courseduration + ", coursetrainer=" + coursetrainer + "]";
	}
	public Course() {
		
	}
	
	

}
