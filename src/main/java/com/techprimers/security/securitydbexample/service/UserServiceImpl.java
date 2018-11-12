package com.techprimers.security.securitydbexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.security.securitydbexample.model.Users;
import com.techprimers.security.securitydbexample.repository.UsersRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UsersRepository usersRepository;
	
	@Override
	public Users findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Users> findByName(String name) {
		// TODO Auto-generated method stub
		return usersRepository.findByName(name);
	}

	@Override
	public void saveUser(Users user) {
		usersRepository.save(user);
		
	}

	@Override
	public void updateUser(Users user) {
		usersRepository.save(user);
		
	}

	@Override
	public void deleteUserById(int id) {
		usersRepository.delete(id);
		
	}

	@Override
	public List<Users> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<Users>) usersRepository.findAll();
	}

	@Override
	public void deleteAllUsers() {
		usersRepository.deleteAll();
		
	}

	@Override
	public boolean isUserExist(Users user) {
		boolean activo = false;
		activo = !findByName(user.getName()).equals(null);
		return activo;
	}

}
