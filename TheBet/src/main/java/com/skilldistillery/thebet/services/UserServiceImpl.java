package com.skilldistillery.thebet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.thebet.entities.User;
import com.skilldistillery.thebet.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User show(int userId) {
		User user = null;
		Optional<User> userOpt = userRepo.findById(userId);
		if (userOpt.isPresent()) {
			user = userOpt.get();
		}
		return user;
	}
	
	@Override
	public User create(User user) {
		//use this space to fix any not null values
		return userRepo.saveAndFlush(user);
	}
	
	@Override
	public User update(int userId, User user) {
		//use this space to fix any not null values
		user.setId(userId);
		return userRepo.saveAndFlush(user);
	}
	
	@Override
	public boolean delete(int userId) {
		userRepo.deleteById(userId);
		return !userRepo.existsById(userId);
	}

}
