package com.WebServices.BOSWeb.Controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServices.BOSWeb.BosWebApplication;
import com.WebServices.BOSWeb.ModelDTO.AccountInformation;
import com.WebServices.BOSWeb.ModelDTO.CustomerRegistration;
import com.WebServices.BOSWeb.ModelDTO.SuccessResponseModel;
import com.WebServices.BOSWeb.ServiceInterface.CR_Service;


@RestController
@RequestMapping("api/user/")
public class CR_Controller {
	private static final Logger logger=Logger.getLogger(BosWebApplication.class.getName());
	@Autowired
	private CR_Service customerService;
	@Autowired
	private SuccessResponseModel response;
	
	
	@PostMapping("/openAccount")
	public SuccessResponseModel registerUser(@RequestBody CustomerRegistration registerCustomer) throws Exception {
		logger.info("Inside /openAccount Controller");
		CustomerRegistration registerAccount;
		try {
		//step :1 register
		 registerAccount = customerService.registerAccount(registerCustomer);
		//step :2 provideDetails
		AccountInformation provideAccountDetails = customerService
				.provideAccountDetails(registerCustomer.getAadharCardNumber());
		//set reponse
	    response.setAccountInformation(provideAccountDetails);
	    response.setCustomerDetails(registerAccount);
	    //save AccountInformation
		    try {
		    	customerService.saveAccountInformation(registerAccount.getId(),
		    			provideAccountDetails,registerAccount.getAadharCardNumber());
		    }catch (RuntimeException exp) {
				throw new RuntimeException("Error Occurred During Processing Account information");
			}
		}catch (Exception e) {
			logger.error("Error Occurred During Processing Account information");
			throw new Exception("Error Occurred During Processing Account information" + e.getLocalizedMessage());
		}
		logger.info("Successfully Opened Account : " + HttpStatus.OK);
		return response;
	}
}
