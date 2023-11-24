package com.WebServices.BOSWeb.ServiceInterface;

import com.WebServices.BOSWeb.ModelDTO.AccountInformation;
import com.WebServices.BOSWeb.ModelDTO.CustomerRegistration;


public interface CR_Service {
	
   public CustomerRegistration registerAccount(CustomerRegistration registerCustomer);

   public AccountInformation provideAccountDetails(String identityProof);

   public void saveAccountInformation(Long id, AccountInformation provideAccountDetails, String string);

}
