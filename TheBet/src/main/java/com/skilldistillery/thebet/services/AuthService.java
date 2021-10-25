package com.skilldistillery.thebet.services;

import com.skilldistillery.thebet.entities.User;

public interface AuthService {
	public User register(User user);
	public User getUser(String username);
}
