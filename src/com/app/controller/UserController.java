package com.app.controller;

import javax.annotation.PostConstruct;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostConstruct
	public void myInit() {
		System.out.println("in init of "+ getClass().getName());
	}
	
//	@GetMapping("/login")
//	public String showLoginForm() {
//		System.out.println("Showing login form");
//		return "/user/login";
//	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestBody Users u, HttpSession hs)
	{
		try {
			Users u1 = service.validateUser(u.getEmail(), u.getPassword());
			System.out.println(u1);
			hs.setAttribute("user_details", u);
			return "logged in";
		}
		catch (RuntimeException e) {
			System.out.println("error");
			return "/user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logMeOut(HttpSession hs, Model map, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in user logout");
		// get user dtls from HS & add them in model map
		map.addAttribute("details", hs.getAttribute("user_details"));
		// discard session
		hs.invalidate();
		// auto navigate the clnt to home page after some dly
		response.setHeader("refresh", "5;url="+request.getContextPath());
		return "/user/logout";
	}
	
	@PostMapping("/register")
	public String registerUserForm(@RequestBody Users u)
	{
		service.registerUser(u);
		return "/admin/componentlist";
	}
}











