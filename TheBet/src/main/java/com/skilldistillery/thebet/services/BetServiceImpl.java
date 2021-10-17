package com.skilldistillery.thebet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.thebet.entities.Bet;
import com.skilldistillery.thebet.repositories.BetRepository;

@Service
public class BetServiceImpl implements BetService {
	@Autowired
	private BetRepository betRepo;
	
	@Override
	public List<Bet> getAllBets() {
		return betRepo.findAll();
	}
	
	@Override
	public Bet show(int betId) {
		Bet bet = null;
		Optional<Bet> betOpt = betRepo.findById(betId);
		if(betOpt.isPresent()) {
			bet = betOpt.get();
		}
		return bet;
	}
	
	@Override
	public Bet create(Bet bet) {
		return betRepo.saveAndFlush(bet);
	}
	
	@Override
	public Bet update(int betId, Bet bet) {
		bet.setId(betId);
		return betRepo.saveAndFlush(bet);
	}
	
	@Override
	public Boolean delete(int betId) {
		betRepo.deleteById(betId);
		return !betRepo.existsById(betId);
	}
}
