package se.coredev.maven.lab;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String username;

	@Embedded
	private Address address;

	@ManyToOne
	private Computer computer;
	
	protected Employee() {
	}

	public Employee(String firstName, String lastName, String username, Address address, Computer computer) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.address = address;
		this.computer = computer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public Address getAddress() {
		return address;
	}

	public Computer getComputer() {
		return computer;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
