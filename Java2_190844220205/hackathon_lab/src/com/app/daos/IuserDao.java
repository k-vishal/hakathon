package com.app.daos;

import java.util.List;

import com.app.pojos.Users;

public interface IuserDao {
	Users validateUser(String email, String password);
	List<Users>listOfUsers();
}
