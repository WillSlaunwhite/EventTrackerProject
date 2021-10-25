package com.skilldistillery.thebet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.thebet.entities.User;
import com.skilldistillery.thebet.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
		// encrypt the user's actual password
		String encodedPW = encoder.encode(user.getPassword());
		
		// set other relevant verification fields
		user.setPassword(encodedPW);
		user.setEnabled(true);
		user.setRole("standard");
		
		// update the user in the database
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}

}

