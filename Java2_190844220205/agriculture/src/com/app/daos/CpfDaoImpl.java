package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.CourseStatus;
import com.app.pojos.UserDetails;

@Repository
public class CpfDaoImpl implements ICpfDao {

	@Autowired 
	private SessionFactory sf;

	@Override
	public Course NewCourse(Course c, int id) {
		
		System.out.println(c);
		UserDetails u = sf.getCurrentSession().get(UserDetails.class, id);
		u.addCourse(c);
		sf.getCurrentSession().saveOrUpdate(u);
		return c;
	}

	@Override
	public List<Course> pendingCourseList() {
		String jpql="select c from Course c where c.courseStatus=:status";
		return  sf.getCurrentSession().createQuery(jpql,Course.class).setParameter("status", CourseStatus.PENDING).getResultList();
		
	}
}
