package com.app.controller;

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











