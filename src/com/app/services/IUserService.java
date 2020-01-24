package com.app.services;

import com.app.pojos.Users;

public interface IUserService {
	Users registerUser(Users u);
	Users validateUser(Users u);
	Users changePassword(Integer id,String password);
	Users getById(int id);
	void deleteUser(int id);
	Users editUser(Users u, int id);
	
}

