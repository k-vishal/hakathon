package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	private int courseId;
	private String courseName;
	private String courseLocation;
	private Date startDate;
	private int courseDays;
	private int noOfReq;
	private UserDetails userDetails;
	private CourseStatus courseStatus;
	
	Course()
	{
		System.out.println("inside the course pojo");
	}


	public Course(int courseId, String courseName, Date startDate, int courseDays, int noOfReq, CourseStatus courseStatus,String courseLocation) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.startDate = startDate;
		this.courseDays = courseDays;
		this.noOfReq = noOfReq;
		this.courseStatus=courseStatus;
		this.courseLocation=courseLocation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseLocation() {
		return courseLocation;
	}


	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public int getCourseDays() {
		return courseDays;
	}


	public void setCourseDays(int courseDays) {
		this.courseDays = courseDays;
	}


	public int getNoOfReq() {
		return noOfReq;
	}


	public void setNoOfReq(int noOfReq) {
		this.noOfReq = noOfReq;
	}

	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="cpf_id")
	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", startDate=" + startDate
				+ ", courseDays=" + courseDays + ", noOfReq=" + noOfReq + ", courseStatus=" + courseStatus + "]";
	}


	

	
}
