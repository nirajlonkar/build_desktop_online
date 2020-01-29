package com.app.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBuildDao;
import com.app.dao.IUserDao;
import com.app.pojos.Builds;
import com.app.pojos.Users;


@Service
@Transactional
public class BuildService implements IBuildService {
	
	@Autowired
	private IBuildDao dao;
	
	@Autowired
	private IUserDao udao;
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public String newBuild(Users u) {
		System.out.println("in service newbuild");
		
		sf.getCurrentSession().update(u);
		return "done";
	}

	@Override
	public List<Builds> getAllBuilds() {
		List<Builds> buildList = dao.listAllBuilds();
		return buildList;
	}

	@Override
	public List<Builds> getBuildById(int id) {
		List<Builds> buildList = dao.listBuildByUserId(id);
		return buildList;
	}

	@Override
	public void deleteBuild(int id, int uid) {
		Builds b = dao.buildById(id);
		Users u = udao.userById(uid);
		if(b!=null)
			u.removeBuild(b);
			dao.delete(b);	
	}

	@Override
	public Builds getBuild(int id) {
		Builds b = dao.buildById(id);
		return b;
	}
	
	
}
