package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Orders;
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
	public Users validateUser(Users u) {
		System.out.println("in service login");
		u = dao.validateUser(u.getEmail(),u.getPassword());
		return u;
	}
	
	@SuppressWarnings("unused")
	@Override
	public Users changePassword(Integer id, String password) {
		Users u=dao.changePassword(id,password);
		return null;
	}
	@Override
	public Users getById(int id) {
		Users u = dao.userById(id);
		return u;
	}
	@Override
	public void deleteUser(int id) {
		Users u = dao.userById(id);
		if(u!=null)
			dao.deleteUser(u);
	}
	@Override
	public Users editUser(Users u, int id) {
		System.out.println("in edit profile");
		Users uOld = dao.userById(id);
		u = dao.editProfile(uOld, u);
		return u;
	}
	@Override
	public Orders addOrder(Users u) {
		System.out.println("inside service add order");
		return dao.addOrder(u);
	}
	@Override
	public List<Orders> ordersByUserId(int id) {
		List<Orders> orderList = dao.byUserID(id);
		return orderList;
	}
	@Override
	public List<Orders> allOrders() {
		List<Orders> orderList = dao.allOrders();
		return orderList;
	}
	

}
