package com.app.dao;

import com.app.pojos.Users;

public interface IUserDao {

	Users validateUser(String email, String pass);
	Users registerUser(Users u);
}
