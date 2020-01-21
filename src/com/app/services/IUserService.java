package com.app.services;

import com.app.pojos.Users;

public interface IUserService {
	Users registerUser(Users u);
	Users validateUser(String email, String password);
}

