package com.app.dao;

import java.util.List;

import com.app.pojos.Components;
import com.app.pojos.Orders;
import com.app.pojos.Users;

public interface IAdminDao {
	
	Components addComponent(Components c);
	void removeComponent(Components c);
	List<Components> listAllComp();
	List<Components> listByType(String type);
	List<Users> listAllUsers();
	Components compById(int id);
	Components editComp(Components cOld, Components c);
	String updateStatus(Orders old);
	Orders orderById(int id);
}
