package se.coredev.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "SELECT e FROM Employee e WHERE e.employeeNumber = :employeeNumber")
})
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

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;

	@ElementCollection
	// private Collection<String> notes;
	private Map<Integer, String> notes;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String employeeNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.notes = new HashMap<>();
	}

	public Long getId() {
		return id;
	}

	public void addNote(Integer id, String note) {
		notes.put(id, note);
	}

	public Map<Integer, String> getNotes() {
		return notes;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
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
}
