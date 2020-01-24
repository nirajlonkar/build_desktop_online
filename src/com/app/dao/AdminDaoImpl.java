package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.ComponentType;
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
	@Override
	public void removeComponent(Components c) {
		sf.getCurrentSession().delete(c);
	}
	@Override
	public Components compById(int id) {
		String jpql = "select c from Components c where id=:id";
		return sf.getCurrentSession().createQuery(jpql,Components.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public Components editComp(Components cOld, Components c) {
		System.out.println("in edit dao");
		cOld.setManufacturer(c.getManufacturer());
		cOld.setName(c.getName());
		cOld.setModel_no(c.getModel_no());
		cOld.setPrice(c.getPrice());
		sf.getCurrentSession().update(cOld);	
		System.out.println("edit update");
		return c;
	}
	@Override
	public List<Components> listByType(String type) {
		System.out.println(type);
		ComponentType typeEnum = ComponentType.valueOf(type);
		String jpql = "select c from Components c where c.type=:type";
		return sf.getCurrentSession().createQuery(jpql,Components.class).setParameter("type", typeEnum).getResultList();
	}
	

}
