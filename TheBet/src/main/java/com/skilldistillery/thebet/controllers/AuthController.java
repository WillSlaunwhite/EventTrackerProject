package com.skilldistillery.thebet.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.thebet.entities.User;
import com.skilldistillery.thebet.services.AuthService;

@RestController
@CrossOrigin({ "*", "http://localhost:4300" })
public class AuthController {
	@Autowired
	private AuthService authSvc;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public User register(@RequestBody User user, HttpServletResponse res) {

	    if (user == null) {
	        res.setStatus(400);
	    }

	    user = authSvc.register(user);

	    return user;
	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.GET)
	public User authenticate(Principal principal) {
//		return principal;
		
		// principal object has getName method that will return authenticated user name
		return authSvc.getUser(principal.getName());
	}
}