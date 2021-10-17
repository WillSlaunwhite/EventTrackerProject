package com.skilldistillery.thebet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.thebet.entities.User;
import com.skilldistillery.thebet.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> getUsers() {
		return userSvc.getAllUsers();
	}
	
	@GetMapping("users/{userId}")
	public User getUser(@PathVariable Integer userId, HttpServletResponse resp) {
		User user = userSvc.show(userId);
		if(user == null) {
			resp.setStatus(404);
		} return user;
	}
	
	@PostMapping("users")
	public User addUser(@RequestBody User user, HttpServletRequest req, HttpServletResponse resp) {
		try {
			user = userSvc.create(user);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(user.getId());
			resp.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(400);
			user = null;
		} return user;
	}
	
	@PutMapping("users/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		return userSvc.update(userId, user);
	}
	
	@DeleteMapping("users/{userId}")
	public Boolean deleteUser(@PathVariable Integer userId) {
		return userSvc.delete(userId);
	}
}
