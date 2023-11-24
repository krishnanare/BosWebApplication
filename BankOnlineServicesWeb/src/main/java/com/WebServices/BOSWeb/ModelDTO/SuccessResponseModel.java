package com.WebServices.BOSWeb.ModelDTO;

import org.springframework.stereotype.Component;

/**
 * @author @KrishnaKumar 2622807
 * ##this class is an response for the customer how succesfully 
 * ##provided valid details and opened bank account
 */
@Component
//@Entity
public class SuccessResponseModel {

//	@javax.persistence.Id
//	private Long Id;

	private CustomerRegistration customerDetails;

	private AccountInformation accountInformation;

	public SuccessResponseModel(CustomerRegistration customerDetails, AccountInformation accountInformation) {
		super();
		//this.Id=id;
		this.customerDetails = customerDetails;
		this.accountInformation = accountInformation;
	}

//	public Long getId() {
//		return Id;
//	}
//
//	public void setId(Long id) {
//		Id = id;
//	}

	public SuccessResponseModel() {
		// TODO Auto-generated constructor stub
	}

	public CustomerRegistration getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerRegistration customerDetails) {
		this.customerDetails = customerDetails;
	}

	public AccountInformation getAccountInformation() {
		return accountInformation;
	}

	public void setAccountInformation(AccountInformation accountInformation) {
		this.accountInformation = accountInformation;
	}

	@Override
	public String toString() {
		return "SuccessResponseModel [customerDetails=" + customerDetails + ", accountInformation=" + accountInformation
				+ "]";
	}
	
	
}
