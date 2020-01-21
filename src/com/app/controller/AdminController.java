package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/addcomponent")
	private String showAddCompForm(Model map)
	{
		System.out.println("in add comp");
		return "/admin/addcomponent";
	}
	
	@PostMapping(value = "/addcomponent")
	private String processAddCompForm(@RequestBody Components c)
	{
		
		System.out.println("in process of add comp");
		service.addComponent(c);
		return "/admin/componentlist";
	}
	
	@GetMapping("/componentlist")
	public ResponseEntity<List<Components>> showComponentList()
	{
		List<Components> listAllComp = service.getAllComp();
		System.out.println(listAllComp);
		if(listAllComp.size()!=0)
			return new ResponseEntity<List<Components>>(listAllComp, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/userlist")
	public ResponseEntity<List<Users>> showUsersList()
	{
		List<Users> listAllUser = service.getAllUsers();
		System.out.println(listAllUser);
		if(listAllUser.size()!=0)
			return new ResponseEntity<List<Users>>(listAllUser, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}


//@RequestParam String name, @RequestParam String manufacturer, @RequestParam String model_no,
//@RequestParam float price, @RequestParam ComponentType comp_type, @RequestParam byte[] desc,
//HttpSession hs, RedirectAttributes flashMap
