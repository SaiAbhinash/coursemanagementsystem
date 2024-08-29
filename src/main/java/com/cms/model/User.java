package com.cms.model;



public class User {
	private int courseid;
	private String coursename;
	private String coursedetails;
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
	public String getCoursedetails() {
		return coursedetails;
	}
	public void setCoursedetails(String coursedetails) {
		this.coursedetails = coursedetails;
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
	public User(int courseid, String coursename, String coursedetails, int courseduration, String coursetrainer) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.coursedetails = coursedetails;
		this.courseduration = courseduration;
		this.coursetrainer = coursetrainer;
	}
	public User() {
	
	}
	@Override
	public String toString() {
		return "User [courseid=" + courseid + ", coursename=" + coursename + ", coursedetails=" + coursedetails
				+ ", courseduration=" + courseduration + ", coursetrainer=" + coursetrainer + "]";
	}
	
	
	
		

}
