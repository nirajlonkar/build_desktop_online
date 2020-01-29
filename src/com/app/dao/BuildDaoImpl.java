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
	public String makeBuild(Users u) {
		System.out.println("in dao of make bbuild");
		sf.getCurrentSession().update(u);
		return "Build created for user "+u.getName();
	}

	@Override
	public List<Builds> listAllBuilds() {
		String jpql = "select b from Builds b"; 
		return sf.getCurrentSession().createQuery(jpql,Builds.class).getResultList();
	}

	@Override
	public List<Builds> listBuildByUserId(int id) {
		
		String jpql = "select b from Builds b where b.user.id=:id"; 
		List<Builds> listBuild = sf.getCurrentSession().createQuery(jpql,Builds.class).setParameter("id", id).getResultList();
		return listBuild ;
	}

	@Override
	public void delete(Builds b) {
		System.out.println(b);
		sf.getCurrentSession().delete(b);
		System.out.println("build deleted");
	}

	@Override
	public Builds buildById(int id) {
		String jpql = "select b from Builds b where b.id=:id"; 
		return sf.getCurrentSession().createQuery(jpql,Builds.class).setParameter("id", id).getSingleResult();
	}

	
}
