package com.skilldistillery.thebet.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String wager;
	private boolean completed;
	
	@Column(name="wager_date")
	private LocalDate wagerDate;
	
	@Column(name="deadline_date")
	private LocalDate deadlineDate;
	
	@ManyToOne
	@JoinColumn(name="bettor_id")
	private User bettor;
	
	@ManyToOne
	@JoinColumn(name="bettee_id")
	private User bettee;
	
	// make unique repo methods to return bettors vs bettees
	

	

	public Bet() { super(); }
	
	public Bet(int id, String name, String wager, boolean completed, LocalDate wagerDate,
			LocalDate deadlineDate, User bettor, User bettee) {
		super();
		this.id = id;
		this.name = name;
		this.wager = wager;
		this.completed = completed;
		this.wagerDate = wagerDate;
		this.deadlineDate = deadlineDate;
		
		if(bettor.getRole() == null) { bettor.setRole("user"); }
		this.bettor = bettor;
		
		if(bettee.getRole() == null) { bettee.setRole("user"); }
		this.bettee = bettee;
	}

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getWagerDate() {
		return wagerDate;
	}
	
	public void setWagerDate(LocalDate wagerDate) {
		this.wagerDate = wagerDate;
	}
	
	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}
	
	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getWager() {
		return wager;
	}

	public void setWager(String wager) {
		this.wager = wager;
	}

	public User getBettor() {
		return bettor;
	}

	public void setBettor(User bettor) {
		this.bettor = bettor;
	}

	public User getBettee() {
		return bettee;
	}

	public void setBettee(User bettee) {
		this.bettee = bettee;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bet [id=").append(id).append(", name=").append(name).append(", wagerDate=").append(wagerDate)
		.append(", deadlineDate=").append(deadlineDate).append(", wager=").append(wager).append(", bettor=")
		.append(bettor).append(", bettee=").append(bettee).append("]");
		return builder.toString();
	}
}
