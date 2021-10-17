package com.skilldistillery.thebet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.thebet.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
