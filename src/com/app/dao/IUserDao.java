package com.app.dao;

import com.app.pojos.Users;

public interface IUserDao {

	Users validateUser(String email, String pass);
	Users registerUser(Users u);
	Users changePassword(Integer id, String password);
	void deleteUser(Users u);
	Users userById(int id);
	Users editProfile(Users uOld, Users u);

}
