package com.skilldistillery.thebet.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private String role;
	
	@JsonBackReference(value="bettor")
	@OneToMany(mappedBy="bettor")
	private List<Bet> betsIssued;
	
	@JsonBackReference(value="bettee")
	@OneToMany(mappedBy="bettee")
	private List<Bet> betsReceived;
	
//	private List<Bet> bets;
	
	public User() { super(); }

	public User(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Bet> getBetsIssued() {
		return betsIssued;
	}

	public void setBetsIssued(List<Bet> betsIssued) {
		this.betsIssued = betsIssued;
	}

	public List<Bet> getBetsReceived() {
		return betsReceived;
	}

	public void setBetsReceived(List<Bet> betsReceived) {
		this.betsReceived = betsReceived;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append(", username=").append(username)
				.append(", password=").append(password).append(", email=").append(email).append(", enabled=")
				.append(enabled).append(", role=").append(role).append(", betsIssued=").append(betsIssued)
				.append(", betsReceived=").append(betsReceived).append("]");
		return builder.toString();
	}

}
