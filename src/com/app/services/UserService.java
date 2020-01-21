package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Users;
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao dao;
	@Override
	public Users registerUser(Users u) {
		u = dao.registerUser(u);
		return u;
	}
	@Override
	public Users validateUser(String email, String password) {
		Users u = dao.validateUser(email, password);
		return u;
	}

}
