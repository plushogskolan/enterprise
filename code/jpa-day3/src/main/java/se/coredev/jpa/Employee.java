package se.coredev.jpa;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String employeeNumber;

	@ManyToOne
	private Department department;
	
	@OneToOne
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;

	@ManyToMany
	private Collection<Project> projects;
	
	protected Employee() {
	}

	public Employee(String firstName, String lastName, String employeeNumber, Department department, 
	                ParkingSpot parkingSpot, Collection<Project> projects) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.department = department;
		this.parkingSpot = parkingSpot;
		this.projects = projects;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public Department getDepartment() {
		return department;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
	
	public Collection<Project> getProjects() {
		return projects;
	}
	
	
}
