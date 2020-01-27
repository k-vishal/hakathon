package com.app.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Books;
import com.app.pojos.Users;

@Repository
@Transactional
public class LibraryDaoImpl implements ILibraryDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Users addUser(Users u) {
		sf.getCurrentSession().persist(u);
		return u;
	}

	@Override
	public Users editProfile(Users u) {
		sf.getCurrentSession().update(u);
		return u;
	}

	@Override
	public Users changePassword(String password, int id) {
		Users u = sf.getCurrentSession().get(Users.class, id);
		u.setPassword(password);
		sf.getCurrentSession().update(u);
		return u;
	}

	@Override
	public Books addBooks(Books b) {
		 sf.getCurrentSession().persist(b);
		return b;
	}

	@Override
	public Books editBooks(Books b) {
		sf.getCurrentSession().update(b);
		return b;
	}

}
