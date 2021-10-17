package com.skilldistillery.thebet.entities;

import java.time.LocalDateTime;

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
	
	@Column(name="wager_date")
	private LocalDateTime wagerDate;
	
	@Column(name="deadline_date")
	private LocalDateTime deadlineDate;
	
	private String wager;
	
	@ManyToOne
	@JoinColumn(name="bettor_id")
	private User bettor;
	
	@ManyToOne
	@JoinColumn(name="bettee_id")
	private User bettee;
	


	public Bet() { super(); }
	
	
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

	public LocalDateTime getWagerDate() {
		return wagerDate;
	}

	public void setWagerDate(LocalDateTime wagerDate) {
		this.wagerDate = wagerDate;
	}

	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDateTime deadlineDate) {
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bet [id=").append(id).append(", name=").append(name).append(", wagerDate=").append(wagerDate)
		.append(", deadlineDate=").append(deadlineDate).append(", wager=").append(wager).append(", bettor=")
		.append(bettor).append(", bettee=").append(bettee).append("]");
		return builder.toString();
	}
}
