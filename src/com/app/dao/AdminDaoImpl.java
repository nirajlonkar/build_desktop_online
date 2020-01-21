package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Components;
import com.app.pojos.Users;
@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Components addComponent(Components c) {
		sf.getCurrentSession().persist(c);
		return c;
	}
	@Override
	public List<Components> listAllComp() {
		String jpql = "select c from Components c";
		return sf.getCurrentSession().createQuery(jpql,Components.class).getResultList();
	}
	@Override
	public List<Users> listAllUsers() {
		String jpql="select u from Users u";
		return sf.getCurrentSession().createQuery(jpql,Users.class).getResultList();
	}
	
	

}
