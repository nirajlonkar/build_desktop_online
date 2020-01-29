package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Orders;
import com.app.pojos.Users;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public Users validateUser(String email, String pass) {
		String query = "select u from Users u where u.email=:em and u.password=:pass";
		System.out.println("in dao login");
		System.out.println(email);
		System.out.println(pass);
		Users u1 = sf.getCurrentSession().createQuery(query,Users.class).setParameter("em", email).setParameter("pass", pass).getSingleResult();
		return u1;
	}
	
	@Override
	public Users registerUser(Users u) {
		sf.getCurrentSession().persist(u);
		return u;
	}
	@Override
	public Users changePassword(Integer id, String password) {
		Users u=sf.getCurrentSession().get(Users.class, id);
		System.out.println(u);
		u.setPassword(password);
		return u;
	}
	
	@Override
	public void deleteUser(Users u) {
		sf.getCurrentSession().delete(u);
	}
	
	@Override
	public Users userById(int id) {
		String jpql = "select u from Users u where u.id=:id";
		return sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("id", id).getSingleResult();
	}
	@Override
	public Users editProfile(Users uOld, Users u) {
		uOld.setName(u.getName());
		uOld.setContact(u.getContact());
		sf.getCurrentSession().update(uOld);
		System.out.println("in edit profile");
		return u;
	}

	@Override
	public Orders addOrder(Users u) {
		System.out.println("inside dao add order");
		sf.getCurrentSession().saveOrUpdate(u);
		Orders o = null;
		return o;
	}

	@Override
	public List<Orders> byUserID(int id) {
		String jpql = "select o from Orders o where o.build_id.user.id=:id";
		return sf.getCurrentSession().createQuery(jpql,Orders.class).setParameter("id", id).getResultList();
	}

	@Override
	public List<Orders> allOrders() {
		String jpql = "select o from Orders o";
		return sf.getCurrentSession().createQuery(jpql,Orders.class).getResultList();
	}	
	
	
	
}
