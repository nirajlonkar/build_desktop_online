package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Components;
import com.app.pojos.Users;

@Service
@Transactional
public class AdminService implements IAdminService {

	@Autowired 
	private IAdminDao dao;
	@Override
	public List<Users> getAllUsers() {
		List<Users> listAll = dao.listAllUsers();
		return listAll;
	}

	@Override
	public List<Components> getAllComp() {
		List<Components> listComp = dao.listAllComp();
		return listComp;
	}

	@Override
	public Components addComponent(Components c) {
		c = dao.addComponent(c);
		return c;
	}

}
