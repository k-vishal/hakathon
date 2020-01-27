package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.daos.ICategoryDao;
import com.app.pojos.CategoryPojo;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private ICategoryDao dao; 
	
	@PostConstruct
	public void myInit()
	{
		System.out.println("inside init ");
	}
	@GetMapping("/category")
	public void showcategory()
	{
		System.out.println("inside of showcategory");
		List<CategoryPojo> C= dao.listCategory();
		
		System.out.println(C);
		
		
	}

}
