package com.skilldistillery.thebet.services;

import java.util.List;

import com.skilldistillery.thebet.entities.Bet;

public interface BetService {

	List<Bet> getAllBets();

	Bet update(int betId, Bet bet);

	Bet create(Bet bet);

	Bet show(int betId);

	Boolean delete(int betId);

}
