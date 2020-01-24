package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Users;
import com.app.services.IUserService;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {

	@Autowired
	private IUserService service;
	
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
}
