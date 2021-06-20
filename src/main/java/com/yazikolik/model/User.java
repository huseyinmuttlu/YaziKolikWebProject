package com.yazikolik.model;
import javax.persistence.*;
/**
 * User.java
 * Copyright by CodeJava.net
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
   
	@Lob
	private String adress;
	private String email;
	private String password;
	private boolean su =false;
	
	public boolean isSu() {
		return su;
	}

	public void setSu(boolean su) {
		this.su = su;
	}

	public User() {
	
	}

	public User(String firstName, String lastName, String phoneNumber, String adress, String email, String password, boolean su) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.su = su;
	}

	public Integer getId() {
		return userID;
	}

	public void setId(Integer id) {
		this.userID = id;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", adress=" + adress + ", email=" + email + ", password=" + password + ", su=" + su + "]";
	}
	
	
}
