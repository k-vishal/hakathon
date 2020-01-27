package com.app.daos;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CategoryPojo;


@Repository
@Transactional
public class CategoryDao implements ICategoryDao{
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<CategoryPojo> listCategory()
	{
		String jpql= "select c.T_CATEGORY from CategoryPojo c" ;
		return sf.getCurrentSession().createQuery(jpql, CategoryPojo.class).getResultList();
	}

}

