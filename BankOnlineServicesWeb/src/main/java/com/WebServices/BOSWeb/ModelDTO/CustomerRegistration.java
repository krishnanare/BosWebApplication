package com.WebServices.BOSWeb.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * 
 * @author krishnakumar
 * CustomerRegistration : Need to provide essential detials of customer 
 * for opening bank account 
 * Ex : UserName: fname,lname,Age,AdharCard Number,PANCard number,Phone Number,EmailId
 *      Address[street/area,locality,pin,city,state]
 *      
 */
@Entity
@Component
public class CustomerRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	private String aadharCardNumber;
	private String panCardNumber;
	private String phoneNumber;
	private String emailId;
	private String Address;
	
	public CustomerRegistration() {}

	public CustomerRegistration(Long id, String firstName, String lastName, String aadharCardNumber,
			String panCardNumber, String phoneNumber, String emailId, String address) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aadharCardNumber = aadharCardNumber;
		this.panCardNumber = panCardNumber;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		Address = address;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
}
