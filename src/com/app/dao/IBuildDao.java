package com.app.dao;

import java.util.List;

import com.app.pojos.Builds;
import com.app.pojos.Users;

public interface IBuildDao {

	Builds makeBuild(Users u);
	List<Builds> listAllBuilds();
	List<Builds> listBuildById(int id);
}
