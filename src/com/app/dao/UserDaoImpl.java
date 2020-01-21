package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Users;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sf;
	@SuppressWarnings("unused")
	@Override
	public Users validateUser(String email, String pass) {
		String jpql = "select u from Users where u.email = :email and u.password = :pass";
		return sf.getCurrentSession().createQuery("jpql", Users.class).setParameter("email", email).
				setParameter("pass", pass).getSingleResult();
	}
	@Override
	public Users registerUser(Users u) {
		sf.getCurrentSession().persist(u);
		return u;
	}	
}
