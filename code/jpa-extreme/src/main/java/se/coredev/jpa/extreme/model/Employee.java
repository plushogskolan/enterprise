package se.coredev.jpa.extreme.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Employee.GetAll", query = "SELECT e FROM Employee e"),
		@NamedQuery(name = "Employee.GetByEmployeeNumber", query = "SELECT e FROM Employee e WHERE e.number = :number")
})
public class Employee extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String number;

	protected Employee(){}
	
	public Employee(String firstName, String lastName, String number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

}
