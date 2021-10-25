package com.skilldistillery.thebet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.thebet.entities.Bet;
import com.skilldistillery.thebet.entities.User;
import com.skilldistillery.thebet.repositories.BetRepository;
import com.skilldistillery.thebet.repositories.UserRepository;

@Service
public class BetServiceImpl implements BetService {
	@Autowired
	private BetRepository betRepo;
	
	@Autowired
	private UserRepository userRepo;
	
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
	public Bet create(String username, Bet bet) {
		// THIS IS SUPER JANK need to find a better way to assign users 
		// through either angular or something else
		User user = userRepo.findByUsername(username);
		if(user!=null) {
			
		}
		
		bet.setBettee(userRepo.findById(1).get());
		bet.setBettor(userRepo.findById(3).get());
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
