package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.pojos.Builds;
import com.app.pojos.Cart;

@Service
@Transactional
public class CartService implements ICartService {
	
	@Autowired
	private ICartDao dao;

	@Override
	public Cart addBuild(Builds b) {
		Cart c = dao.addToCart(b);
		return c;
	}

}
