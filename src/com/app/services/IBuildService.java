package com.app.services;

import java.util.List;

import com.app.pojos.Builds;
import com.app.pojos.Users;

public interface IBuildService {

	Builds newBuild(Users u);
	List<Builds> getAllBuilds();
	List<Builds> getBuildById(int id);
}
