package com.app.services;

import java.util.List;

import com.app.pojos.Builds;
import com.app.pojos.Users;

public interface IBuildService {

	String newBuild(Users u);
	List<Builds> getAllBuilds();
	List<Builds> getBuildById(int id);
	void deleteBuild(int id, int uid);
	Builds getBuild(int id);
	
}
