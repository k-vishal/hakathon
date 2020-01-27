package com.app.daos;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Product;

@Repository
@Transactional
public class ProductDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Product> listProduct();
	{
		
	}
}









