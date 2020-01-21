package com.app.dao;

import java.util.List;

import com.app.pojos.Components;
import com.app.pojos.Users;

public interface IAdminDao {
	
	Components addComponent(Components c);
	List<Components> listAllComp();
	List<Users> listAllUsers();
}
