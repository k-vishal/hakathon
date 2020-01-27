package com.app.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Users;

@Repository
@Transactional
public class userDaoImpl implements IuserDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Users validateUser(String email, String password) {
		System.out.println("inside valiate user");
		System.out.println(email+" "+password);
		String jpql = "select u from Users u where u.email=:em and u.password=:pwd";
		
		System.out.println("jpql string "+jpql);
		return sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("em", email).setParameter("pwd", password).getSingleResult();
	}

	@Override
	public List<Users> listOfUsers() {
		System.out.println("userdaoimpl listOfUsers()");
		String jpql="select u from Users u";
		
		return sf.getCurrentSession().createQuery(jpql, Users.class).getResultList();
	}
	

}
