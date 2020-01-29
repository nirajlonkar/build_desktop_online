package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Components;
import com.app.pojos.Orders;
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

	@Override
	public Components getById(int id) {
		Components c = dao.compById(id);
		return c;
	}

	@Override
	public void deleteComponent(int id) {
		Components c = dao.compById(id);
		if(c!=null)
			dao.removeComponent(c);
	}

	@Override
	public Components editComp(Components c, int id) {
		System.out.println("in edit service");
		Components cOld = dao.compById(id);
		c = dao.editComp(cOld,c);
		return c;
	}

	@Override
	public List<Components> getCompByType(String type) {
		List<Components> listComp = dao.listByType(type);
		return listComp;
	}

	@Override
	public String updateStatus(int id) {
		Orders o = dao.orderById(id);
		String a = dao.updateStatus(o);
		return a;
	}

	@Override
	public Components getCompDetails(int id) {
		Components c = dao.compById(id);
		return c;
	}
	
	

}
