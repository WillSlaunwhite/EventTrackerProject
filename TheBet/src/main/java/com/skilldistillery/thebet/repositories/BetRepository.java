package com.skilldistillery.thebet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.thebet.entities.Bet;

public interface BetRepository extends JpaRepository<Bet, Integer> {

}
