package com.apress.prospring5.ch5;

/**
 * Created by iuliana.cosmina on 4/9/17.
 */
//The TargetBean shows a simple class that we use to test IsModifiedMixin. 
//This bean has a single property, name, that we use when we are testing 
//the modification check mixin. 
public class Contact {

	private String name;
	private String phoneNumber;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
