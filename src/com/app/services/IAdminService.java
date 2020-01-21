package com.app.services;

import java.util.List;

import com.app.pojos.Components;
import com.app.pojos.Users;

public interface IAdminService {
	
	List<Users> getAllUsers();
	List<Components> getAllComp();
	Components addComponent(Components c);

}
