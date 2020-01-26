package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Builds;
import com.app.pojos.Cart;
@Repository
public class CartDaoImpl implements ICartDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Cart addToCart(Builds b) {
		sf.getCurrentSession().saveOrUpdate(b);
		Cart c = null;
		return c;
	}
	

}
