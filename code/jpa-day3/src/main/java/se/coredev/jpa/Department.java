package se.coredev.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToMany(mappedBy = "department")
	private Collection<Employee> employees;

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public Collection<Employee> getEmployees() {
		return employees;
	}

	public String getName() {
		return name;
	}
}
