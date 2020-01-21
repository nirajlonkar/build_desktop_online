package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	private Integer id;
	private int build_id;
	private float build_price;
	private Users user;
	
	public Cart() {
		
	}

	public Cart(int build_id, float build_price) {
		super();
		this.build_id = build_id;
		this.build_price = build_price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBuild_id() {
		return build_id;
	}

	public void setBuild_id(int build_id) {
		this.build_id = build_id;
	}

	public float getBuild_price() {
		return build_price;
	}

	public void setBuild_price(float build_price) {
		this.build_price = build_price;
	}
	
	@OneToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Cart [build_id=" + build_id + ", build_price=" + build_price + "]";
	}
	
	
}
