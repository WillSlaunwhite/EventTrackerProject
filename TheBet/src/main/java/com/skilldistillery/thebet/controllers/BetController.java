package com.skilldistillery.thebet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.thebet.entities.Bet;
import com.skilldistillery.thebet.services.BetService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4300"})
public class BetController {
	@Autowired
	private BetService betSvc;
	
	@GetMapping("bets")
	public List<Bet> getBets() {
		return betSvc.getAllBets();
	}
	
	@GetMapping("bets/{betId}")
	public Bet getBet(@PathVariable Integer betId, HttpServletResponse resp) {
		Bet bet = betSvc.show(betId);
		if(bet == null) {
			resp.setStatus(404);
		} return bet;
	}
	
	@PostMapping("bets")
	public Bet addBet(@RequestBody Bet bet, HttpServletResponse resp, HttpServletRequest req) {
		try {
			bet = betSvc.create(bet);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(bet.getId());
			resp.setHeader("Location", url.toString());
			
		} catch(Exception e) {
			System.err.println(e);
			resp.setStatus(400);
			bet = null;
		} return bet;
	}
	
	@PutMapping("bets/{betId}")
	public Bet updateBet(@PathVariable Integer betId, @RequestBody Bet bet) {
		return betSvc.update(betId, bet);
	}
	
	@DeleteMapping("bets/{betId}")
	public boolean deleteUser(@PathVariable Integer betId) {
		return betSvc.delete(betId);
	}
}
