package com.app.services;

import java.util.List;

import com.app.pojos.Components;
import com.app.pojos.Users;

public interface IAdminService {
	
	List<Users> getAllUsers();
	List<Components> getAllComp();
	List<Components> getCompByType(String type);
	Components addComponent(Components c);
	Components getById(int id);
	void deleteComponent(int id);
	Components editComp(Components c, int id);
	String updateStatus(int id);
	Components getCompDetails(int id);
}
