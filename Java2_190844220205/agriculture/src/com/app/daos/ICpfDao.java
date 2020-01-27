package com.app.daos;

import java.util.List;

import com.app.pojos.Course;

public interface ICpfDao {
	Course NewCourse(Course u, int id) ;
	List<Course> pendingCourseList() ;

}
