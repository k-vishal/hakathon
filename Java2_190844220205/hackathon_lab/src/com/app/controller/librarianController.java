package com.app.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.ILibraryDao;
import com.app.daos.IuserDao;
import com.app.pojos.Books;
import com.app.pojos.Role;
import com.app.pojos.Users;

@RestController
@CrossOrigin
@RequestMapping("/librarian")
public class librarianController {
	
	@Autowired
	private ILibraryDao ldao;
	@Autowired
	private IuserDao udao;
	@PostConstruct
	public void myInit() {
		System.out.println("in init of"+getClass().getName()+"dao" );
	}
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody Users u)
	{
		System.out.println(u.toString());
		Users users= udao.validateUser(u.getEmail(), u.getPassword());
		System.out.println(users.toString());
		if(users.getRole().equals(Role.Librarian))
		{
			System.out.println("login for librarian");
			return new ResponseEntity<Users>(users, HttpStatus.OK);
		}
		System.out.println("login for other");
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Users u)
	{
		System.out.println(u.toString());
		Users users= ldao.addUser(u);
		return new ResponseEntity<Users>(users, HttpStatus.CREATED);
	}
	@PostMapping("/editProfile")
	public ResponseEntity<?> editUser(@RequestBody Users u)
	{
		System.out.println(u.toString());
		Users users=ldao.editProfile(u);
		return new ResponseEntity<Users>(users, HttpStatus.OK);	
	}
	@PostMapping("/changepassword/{id}")
	public ResponseEntity<?> changePassword(@RequestBody Users u, @PathVariable int id)
	{
		System.out.println("user id"+id);
		System.out.println(u.toString());
		Users users=ldao.changePassword(u.getPassword(), id);
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}
	@PostMapping("/addBook")
	public ResponseEntity<?> addBook(@RequestBody Books b)
	{
		System.out.println(b.toString());
		Books books=ldao.addBooks(b);
		return new ResponseEntity<Books>(books, HttpStatus.CREATED);
	}
	@PostMapping("/editBook")
	public ResponseEntity<?> editBook(@RequestBody Books b)
	{
		System.out.println(b.toString());
		Books books= ldao.editBooks(b);
		return new ResponseEntity<Books>(books, HttpStatus.OK);
	}
	
	
	
	
}