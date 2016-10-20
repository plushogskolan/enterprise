package se.coredev.maven.lab;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Computer {

	@Id
	@GeneratedValue
	private Long id;

	private String type;
	
	@OneToMany(mappedBy = "computer")
	private Collection<Employee> employees;

	protected Computer() {}

	public Computer(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public Collection<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return type;
	}

}
