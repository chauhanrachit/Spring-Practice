package com.practice.rest.webservices.restfulwebservices.versioning;

public class Name {
	private String firstName;
	private String seondName;
	public Name(String firstName, String seondName) {
		super();
		this.firstName = firstName;
		this.seondName = seondName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSeondName() {
		return seondName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", seondName=" + seondName + "]";
	}
}
