package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Orders {
	
	private Integer id;
//	private int user_id;
	private int build_id;
	private float oprice;
	private Date placed_date;
	private Date delivery_date;
	private Users user;
	
	public Orders() {

	}
	
	public Orders(Integer id, int build_id, float oprice, Date placed_date, Date delivery_date) {
		super();
		this.id = id;
//		this.user_id = user_id;
		this.build_id = build_id;
		this.oprice = oprice;
		this.placed_date = placed_date;
		this.delivery_date = delivery_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	@Column(name = "user_id")
//	public int getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	
	public int getBuild_id() {
		return build_id;
	}
	public void setBuild_id(int build_id) {
		this.build_id = build_id;
	}
	public float getOprice() {
		return oprice;
	}
	public void setOprice(float oprice) {
		this.oprice = oprice;
	}
	@Column(name = "order_date")
	public Date getPlaced_date() {
		return placed_date;
	}
	public void setPlaced_date(Date placed_date) {
		this.placed_date = placed_date;
	}
	@Column(name = "delivery_date")
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", build_id=" + build_id + ", oprice=" + oprice
				+ ", placed_date=" + placed_date + ", delivery_date=" + delivery_date + ", user=" + user + "]";
	}
	
	
}
