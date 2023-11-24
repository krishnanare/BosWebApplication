package com.WebServices.BOSWeb.ModelDTO;

public class CustomerLoginDTO {
	private Double CustomerId;
	private String Password;
	public CustomerLoginDTO(Double customerId, String password) {
		super();
		CustomerId = customerId;
		Password = password;
	}
	public Double getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(Double customerId) {
		CustomerId = customerId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
