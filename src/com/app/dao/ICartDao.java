package com.app.dao;

import com.app.pojos.Builds;
import com.app.pojos.Cart;

public interface ICartDao {
	

	Cart addToCart(Builds b);
}
