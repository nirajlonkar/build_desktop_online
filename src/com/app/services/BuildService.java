package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBuildDao;
import com.app.pojos.Builds;
import com.app.pojos.Users;


@Service
@Transactional
public class BuildService implements IBuildService {
	
	@Autowired
	private IBuildDao dao;

	@Override
	public Builds newBuild(Users u) {
		return dao.makeBuild(u);
	}

	@Override
	public List<Builds> getAllBuilds() {
		List<Builds> buildList = dao.listAllBuilds();
		return buildList;
	}

	@Override
	public List<Builds> getBuildById(int id) {
		List<Builds> buildList = dao.listBuildById(id);
		return buildList;
	}
	
	
}
