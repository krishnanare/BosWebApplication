package com.WebServices.BOSWeb.ModelDTO;

import javax.persistence.Entity;

/**
 * @author 2622807
 *
 */
@Entity
public class AcountDebitNumbersDTO {

	@javax.persistence.Id
	private Long Id;
	
	private String identityProof;  //taking AdharCard as id proof
	
	private String accountNumber;
	
	private Long CustomerId;

	public AcountDebitNumbersDTO(Long id, String identityProof, String accountNumber, Long customerId) {
		super();
		Id = id;
		this.identityProof = identityProof;
		this.accountNumber = accountNumber;
		CustomerId = customerId;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}

	@Override
	public String toString() {
		return "AcountDebitNumbers [Id=" + Id + ", identityProof=" + identityProof + ", accountNumber=" + accountNumber
				+ ", CustomerId=" + CustomerId + "]";
	}
	
	
	
}
