package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Components;
import com.app.pojos.Users;
import com.app.services.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	private IAdminService service;;
	
	@PostMapping(value = "/add-component")
	private ResponseEntity<?> processAddCompForm(@RequestBody Components c)
	{
		System.out.println("in process of add comp");
		try {
			return new ResponseEntity<Components>(service.addComponent(c),HttpStatus.CREATED);
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/component-list")
	public ResponseEntity<List<Components>> showComponentList()
	{
		List<Components> listAllComp = service.getAllComp();
		System.out.println(listAllComp);
		if(listAllComp.size()!=0)
			return new ResponseEntity<List<Components>>(listAllComp, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/component-list/{type}")
	public ResponseEntity<List<Components>> compListByType(@PathVariable String type)
	{
		System.out.println(type);
		System.out.println("Inside comp list by type");
		List<Components> listAllComp = service.getCompByType(type);
		System.out.println(listAllComp);
		if(listAllComp.size()!=0)
			return new ResponseEntity<List<Components>>(listAllComp, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/user-list")
	public ResponseEntity<List<Users>> showUsersList()
	{
		List<Users> listAllUser = service.getAllUsers();
		System.out.println(listAllUser);
		if(listAllUser.size()!=0)
			return new ResponseEntity<List<Users>>(listAllUser, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listById(@PathVariable int id)
	{
		Components c = service.getById(id);
		System.out.println(c);
		if(c==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Components>(c, HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public void deleteComponent(@PathVariable int id)
	{
		System.out.println("in delete of "+id);
		service.deleteComponent(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editComponent(@RequestBody Components c, @PathVariable int id)
	{
		System.out.println("in edit component");
		c = service.editComp(c,c.getId());
		System.out.println("c");
		if(c!=null)
			return new ResponseEntity<Components>(HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}
}
