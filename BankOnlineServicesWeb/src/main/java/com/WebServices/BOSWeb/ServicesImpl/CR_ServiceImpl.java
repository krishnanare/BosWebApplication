package com.WebServices.BOSWeb.ServicesImpl;

import java.util.Map;

import javax.management.RuntimeErrorException;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.WebServices.BOSWeb.ExceptionHandler.DetailsAlreadyExits;
import com.WebServices.BOSWeb.ModelDTO.AccountInformation;
import com.WebServices.BOSWeb.ModelDTO.CustomerRegistration;
import com.WebServices.BOSWeb.ModelDTO.SuccessResponseModel;
import com.WebServices.BOSWeb.Repository.AccountInfromationRepo;
import com.WebServices.BOSWeb.Repository.CR_Repository;
//import com.WebServices.BOSWeb.Repository.SuccessResponseRepo;
import com.WebServices.BOSWeb.ServiceInterface.CR_Service;

@Service
public class CR_ServiceImpl implements CR_Service {
 
	private static final Logger log=Logger.getLogger(CR_ServiceImpl.class.getName());
	
	@Autowired
	private CR_Repository crRepo;
	@Autowired
	private UtilityService util;
	@Autowired
	private AccountInformation accountInformation;
	@Autowired
	private AccountInfromationRepo actRepo;
	
	//step1 :register user
	@Override
	public CustomerRegistration registerAccount(CustomerRegistration registerCustomer) {
		CustomerRegistration register = null;
		/* check 1 : validating the user provided details are valid or not */
		log.info(Logger.Level.INFO + " Check1 : validating the user provided details are valid or not");
		util.validateCustomerDetails(registerCustomer);
		/* check 2: 
		 * check is Pan , adhar , email and phone number already exits for another user in db
		 */
		log.info(Logger.Level.INFO + " Check2 : validating the user provided details already exits for another user in db");
		boolean checkCustomerDetailsExists = util.checkCustomerDetailsExists(registerCustomer);
		if(checkCustomerDetailsExists) {
		try {
		log.info("Inside Save Details Of Customer Details");
		  register = crRepo.save(registerCustomer);
		}catch(DetailsAlreadyExits exp) {
			log.error("Details Provided Already Exists : " + exp.getResourceField() );
			throw new DetailsAlreadyExits("User Details Already Exixts", "");
		}}
		return register;
	}

	//step 2 : provide user infor details
	@Override
	public AccountInformation provideAccountDetails(String identityProof) { 
		try {
		Map<String, String> accountDetails = 
				util.provideCustomerDetails(identityProof); //return [customer id ,Account number]
		
		String AccountNumber = accountDetails.get("AccountNumber");
		String CustomerID = accountDetails.get("CustomerID");
		//String debitcarddetialsurl = accountInformation.getDebitCardDetialsUrl();
		String debitcarddetialsurl=accountDetails.get("DebitCardDetialsUrl");
		String setnetbankingpasswordurl =accountDetails.get("SetNetBankingPasswordUrl");
		//String setnetbankingpasswordurl = accountInformation.getSetNetBankingPasswordUrl();

		accountInformation.setAccountNumber(AccountNumber);
		accountInformation.setCustomerId(CustomerID);
		accountInformation.setDebitCardDetialsUrl(debitcarddetialsurl);
		accountInformation.setSetNetBankingPasswordUrl(setnetbankingpasswordurl);

		}catch (Exception e) {
			log.error("Error While generating and setting accountInfromaiton details :Method: provideAccountDetails "+ 
					CR_ServiceImpl.class);
		}
		return accountInformation;
	   }

	@Override
	public void saveAccountInformation(Long id, AccountInformation provideAccountDetails,String aadharCardNum) {
		try {
			provideAccountDetails.setAadharCard(aadharCardNum);
			provideAccountDetails.setId(id);
			actRepo.save(provideAccountDetails);
			log.info("Account Information Saved In DB : " +HttpStatus.ACCEPTED);
		}catch (RuntimeException exp) {
			log.error("Error saving accountInfromaiton details :Method: saveAccountInformation "+ 
		CR_ServiceImpl.class + HttpStatus.BAD_REQUEST);
				throw new RuntimeException(exp.getLocalizedMessage());
			}
		
	}
}
