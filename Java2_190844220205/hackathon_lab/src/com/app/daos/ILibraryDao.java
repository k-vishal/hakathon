package com.app.daos;

import com.app.pojos.Books;
import com.app.pojos.Users;

public interface ILibraryDao {
	Users addUser(Users u);
	Users editProfile(Users u);
	Users changePassword(String password,int id);
	Books addBooks(Books b);
	Books editBooks(Books b);
	
	
}
