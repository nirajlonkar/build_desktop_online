package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class Users {
	
	private Integer id;
	@NotEmpty(message = "Name is required!")
	private String name;
	@Email(message = "Invalid Email format!")
	@NotEmpty(message = "Email is required!")
	private String email;
	private String contact;
	private String password;
	private UserType type;
	private int builds;
	@JsonIgnore
	private List<Builds> build = new ArrayList<>();
	@JsonIgnore
	private List<Orders> order = new ArrayList<>();
	@JsonIgnore
	private Cart cart;
	public Users() {
	}
	
	public Users(String name, String email, String contact, String password,
			UserType type, int builds) {
		
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.type = type;
		this.builds = builds;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 80)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 15)
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Column(length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBuilds() {
		return builds;
	}
	public void setBuilds(int builds) {
		this.builds = builds;
	}	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "user_type")
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<Builds> getBuild() {
		return build;
	}

	public void setBuild(List<Builds> build) {
		this.build = build;
	}
	
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	@OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	//convenience methods
	public void addCart(Cart c)
	{
		this.cart = c;
		c.setUser(this);
	}
	public void removeCard(Cart c) {
		cart = null;
		c.setUser(null);
	}
	
	public void addBuild(Builds b)
	{
		System.out.println(b);
		build.add(b);
		b.setUser(this);
	}
	
	public void removeBuild(Builds b)
	{
		System.out.println(b);
		build.remove(b);
		b.setUser(null);
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", password=" + password + ", builds=" + builds + "]";
	}


}
