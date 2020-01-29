package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Components;
import com.app.pojos.Orders;
import com.app.pojos.Users;
import com.app.services.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private IUserService service;
	
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init of "+ getClass().getName());
	}
	
	@PostMapping("/login")
	public Users processLoginForm(@RequestBody Users u, HttpSession hs)
	{
		try {
			u = service.validateUser(u);
			System.out.println(u);
			hs.setAttribute("user_details", u);
			return u;
		}
		catch (RuntimeException e) {
			System.out.println("error");
			return null;
		}
	}
	
	@PostMapping("/register")
	public Users registerUserForm(@RequestBody Users u)
	{
		System.out.println("in register controller");
		System.out.println(u);
		service.registerUser(u);
		return u;
	}

	@PutMapping("/changepass")
	public ResponseEntity<?> changePassword(@RequestBody Users u)
	{
		System.out.println("in change ppass");
		System.out.println(u);
		u=service.changePassword(u.getId(),u.getPassword());
		if(u!=null)
			return new ResponseEntity<Users>(u, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editProfile(@RequestBody Users u, @PathVariable int id)
	{
		System.out.println("in edit component");
		u = service.editUser(u,u.getId());
		System.out.println(u);
		if(u!=null)
			return new ResponseEntity<Components>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listById(@PathVariable int id)
	{
		Users u = service.getById(id);
		System.out.println(u);
		if(u==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Users>(u, HttpStatus.OK);

	}
	@PostMapping("/order/{id}")
	private ResponseEntity<?> placeOrder(@RequestBody Orders o, HttpSession hs, @PathVariable int id)
	{
		System.out.println("in process of new order");
		try {
			System.out.println(id);
			float totalPrice = o.getOprice()*o.getQty();
			o.setOprice(totalPrice);
			Users u = service.getById(id);
			System.out.println(u);
			u.placeOrder(o);
			return new ResponseEntity<Orders>(service.addOrder(u),HttpStatus.CREATED);
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/order/list/{id}")
	private ResponseEntity<?> orderList(@PathVariable int id)
	{
		System.out.println("int order list");
		List<Orders> listAllOrders = service.ordersByUserId(id);
		System.out.println(listAllOrders);
		if(listAllOrders.size()!=0)
			return new ResponseEntity<List<Orders>>(listAllOrders, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/order/list")
	private ResponseEntity<?> allOrders()
	{
		List<Orders> allOrders = service.allOrders();
		if(allOrders.size()!=0)
			return new ResponseEntity<List<Orders>>(allOrders,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/logout")
//	public String logMeOut(HttpSession hs, Model map, HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("in user logout");
//		// get user dtls from HS & add them in model map
//		map.addAttribute("details", hs.getAttribute("user_details"));
//		// discard session
//		hs.invalidate();
//		// auto navigate the clnt to home page after some dly
//		response.setHeader("refresh", "5;url="+request.getContextPath());
//		return "/user/logout";
//	}
}











