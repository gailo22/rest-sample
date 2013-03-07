package com.gailo22.model;

import javax.xml.bind.annotation.XmlElement;

public class Address {

	@XmlElement(required = true)
	protected int number;

	@XmlElement(required = true)
	protected String street;

	@XmlElement(required = true)
	protected String city;

	@XmlElement(required = true)
	protected String state;

	@XmlElement(required = true)
	protected String zip;

	@XmlElement(required = true)
	protected String country;

	public Address() {
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
