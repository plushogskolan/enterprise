package se.coredev.jpa.day3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Metadata {

	@Id
	@GeneratedValue
	private Long id;

	private String content;

	protected Metadata() {
	}

	public Metadata(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
