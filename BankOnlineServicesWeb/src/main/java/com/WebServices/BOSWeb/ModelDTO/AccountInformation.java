package com.WebServices.BOSWeb.ModelDTO;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 2622807
 * @BOSApplication will provide customerID ,AccountNumber,DebitCardDetials.....
 */
@Entity
@Component
public class AccountInformation {
	
	private static final Logger log=Logger.getLogger(AccountInformation.class);
	@javax.persistence.Id
	private Long Id;

	private String CustomerId;
	
	private String AccountNumber;
	@JsonIgnore
    private String aadharCard;
	@Transient
	private  String DebitCardDetialsUrl; //="http://localhost:8080/api/user/{CustomerID}/DebitCard/";
	@Transient
	private  String SetNetBankingPasswordUrl; //="http://localhost:8080/api/user/{CustomerID}/SetPassword/";

	public AccountInformation(String customerId, String accountNumber) {
		super();
		CustomerId = customerId;
		AccountNumber = accountNumber;
	}

	public AccountInformation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public AccountInformation(Long id, String customerId, String accountNumber, String aadharCard,
			String debitCardDetialsUrl, String setNetBankingPasswordUrl) {
		super();
		Id = id;
		CustomerId = customerId;
		AccountNumber = accountNumber;
		this.aadharCard = aadharCard;
		DebitCardDetialsUrl = debitCardDetialsUrl;
		SetNetBankingPasswordUrl = setNetBankingPasswordUrl;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public static Logger getLog() {
		return log;
	}

	public String getDebitCardDetialsUrl() {
		return DebitCardDetialsUrl;
	}

	public void setDebitCardDetialsUrl(String debitCardDetialsUrl) {
		DebitCardDetialsUrl = debitCardDetialsUrl;
	}

	public String getSetNetBankingPasswordUrl() {
		return SetNetBankingPasswordUrl;
	}

	public void setSetNetBankingPasswordUrl(String setNetBankingPasswordUrl) {
		SetNetBankingPasswordUrl = setNetBankingPasswordUrl;
	}

	
	

	
}
