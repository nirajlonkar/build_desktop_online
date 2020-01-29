package com.app.dao;

import java.util.List;

import com.app.pojos.Builds;
import com.app.pojos.Users;

public interface IBuildDao {

	String makeBuild(Users u);
	List<Builds> listAllBuilds();
	void delete(Builds b);
	List<Builds> listBuildByUserId(int id);
	Builds buildById(int id);
}
