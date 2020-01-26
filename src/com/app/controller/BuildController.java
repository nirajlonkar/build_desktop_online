package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Builds;
import com.app.pojos.Users;
import com.app.services.IBuildService;
import com.app.services.IUserService;

@RestController
@RequestMapping("/build")
@CrossOrigin
public class BuildController {
	
	@Autowired
	private IBuildService service;
	@Autowired
	private IUserService uservice;
	
	@PostMapping("/new/{id}")
	private ResponseEntity<?> newBuild(@RequestBody Builds b, HttpSession hs, @PathVariable int id)
	{
		System.out.println("in process of new build");
		try {
			System.out.println(id);
			Users u = uservice.getById(id);
			System.out.println(u);
			u.addBuild(b);
			return new ResponseEntity<Builds>(service.newBuild(u),HttpStatus.CREATED);
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	private ResponseEntity<List<Builds>> getAllBuildList()
	{
		List<Builds> buildList = service.getAllBuilds();
		if(buildList.size()!=0)
			return new ResponseEntity<List<Builds>>(buildList,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/list/{id}")
	private ResponseEntity<List<Builds>> getBuildById(@PathVariable int id)
	{
		List<Builds> buildList = service.getBuildById(id);
		if(buildList.size()!=0)
			return new ResponseEntity<List<Builds>>(buildList,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
