package se.coredev.maven.lab;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Embeddable
public class Address {

	private String street;
	private String postal;
	private String zip;
	
	protected Address(){}

	public Address(String street, String postal, String zip) {
		this.street = street;
		this.postal = postal;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getPostal() {
		return postal;
	}

	public String getZip() {
		return zip;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
