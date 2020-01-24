package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Builds;
import com.app.pojos.Users;
@Repository
public class BuildDaoImpl implements IBuildDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Builds makeBuild(Users u) {
		sf.getCurrentSession().persist(u);
		Builds b = null;
		return b;
	}

	@Override
	public List<Builds> listAllBuilds() {
		String jpql = "select b from Builds b"; 
		return sf.getCurrentSession().createQuery(jpql,Builds.class).getResultList();
	}

	@Override
	public List<Builds> listBuildById(int id) {
		String jpql = "select b from Builds b where user_id=:id"; 
		return sf.getCurrentSession().createQuery(jpql,Builds.class).setParameter("id", id).getResultList();
	}

	
}
