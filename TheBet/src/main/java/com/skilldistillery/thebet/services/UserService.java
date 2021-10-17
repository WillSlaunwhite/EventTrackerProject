package com.skilldistillery.thebet.services;

import java.util.List;

import com.skilldistillery.thebet.entities.User;

public interface UserService {
	public List<User> getAllUsers();

	User show(int userId);

	User create(User user);

	User update(int userId, User user);

	boolean delete(int filmId);
}
