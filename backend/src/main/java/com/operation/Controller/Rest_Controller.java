package com.operation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.operation.Model.Users;
import com.operation.Service.Services;

@RestController
public class Rest_Controller {

	
	@Autowired
	private Services service;
	
	
	// Add user 
	@PostMapping("/add")
	public String Adduser(
			@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("age")int age,
			Users user) {
		
		service.adduser(user);
		
		return "successfully added";
		
	}
	
	// Retrieve data from database
	@GetMapping("/showdata")
	public List<Users> showdata() {		
		return service.showdata();
		
	}
	
	// Retrieve data by ID
	@GetMapping("/FindbyId/")
	public List<Users> getById(@RequestParam("id")int id){
		return service.getById(id);
				
	}
	
	// Update data
	@PostMapping("/Update")
	public String updatedata(
			@RequestParam("id")int id,
			@RequestParam("firstname")String firstname,
			@RequestParam("lastname")String lastname,
			@RequestParam("age")int age
			) {
		Users find = service.findbyId(id);
		find.setFirstname(firstname);
		find.setLastname(lastname);
		find.setAge(age);
		service.updatedata(find);
		
		return "successfully update";
		
	}
	
	//Delete data
	@PostMapping("/delete")
	public String deleteData(@RequestParam("id")int id) {
		return service.delete(id);
		
	}
	
	//https://github.com/Benjiealcontin/Simple-CRUD-Fullstack.git
	
}
