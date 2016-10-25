package se.coredev.jpa.extreme.model;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

	private String username;

	protected User() {
	}

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}
