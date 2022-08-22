package com.operation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.operation.Model.Users;
import com.operation.Repository.UserRepository;

@Service
public class Services {
	
	@Autowired
	private UserRepository repo;
	
	// add user
	public Users adduser(Users user) {
		return repo.save(user);
		
	}
	
	// retrieve data from database
	public List<Users> showdata() {
		return (List<Users>)repo.findAll();
		
	}
	
	// retrieve data by Id
	public List<Users> getById(int id) {
		return repo.findByid(id);
		
	}
	
	// retrieve data by Id
	public Users findbyId(int id) {
		return repo.findById(id);
		
	}
	
	//Update data
	public Users updatedata(Users user) {
		Users update = repo.findById(user.getId());
		update.setFirstname(user.getFirstname());
		update.setLastname(user.getLastname());
		update.setAge(user.getAge());
		return repo.save(user);
		
	}
	
	//Delete data
	public String delete(int id) {
		repo.deleteById(id);
		return "successfully deleted id number : " + id;
		
	}

}
