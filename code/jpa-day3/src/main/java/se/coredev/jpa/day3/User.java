package se.coredev.jpa.day3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String username;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;
	
	@ManyToOne
	private Metadata metadata;

	protected User() {
	}

	public User(String username, Role role){
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public Metadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Role getRole() {
		return role;
	}

}
