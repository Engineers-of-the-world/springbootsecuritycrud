package com.techprimers.security.securitydbexample.service;

import java.util.List;
import java.util.Optional;

import com.techprimers.security.securitydbexample.model.Users;


public interface UserService {
	Users findById(long id);
	
	Optional<Users> findByName(String name);
	
	void saveUser(Users user);
	
	void updateUser(Users user);
	
	void deleteUserById(int id);

	List<Users> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(Users user);
}
