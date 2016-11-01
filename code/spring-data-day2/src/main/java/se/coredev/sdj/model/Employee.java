package se.coredev.sdj.model;

import javax.persistence.Column;
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
	private String number;

	@ManyToOne
	private Address address;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String number, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
