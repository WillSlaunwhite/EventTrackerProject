package com.skilldistillery.thebet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.thebet.entities.Bet;

public interface BetRepository extends JpaRepository<Bet, Integer> {
	// return list of bets by user_username and then id as well
	// so here it would bettee_username and bettor_username
	
	// for encyrpting the passwords in mysql workbench, use postman to 
	// register a new user and save that password in mysql workbench
	
	
}
