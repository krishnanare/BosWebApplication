package com.WebServices.BOSWeb.ServicesImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.WebServices.BOSWeb.ExceptionHandler.DetailsAlreadyExits;
import com.WebServices.BOSWeb.ExceptionHandler.InvalidCustomerDetials;
import com.WebServices.BOSWeb.ModelDTO.CustomerRegistration;
import com.WebServices.BOSWeb.Repository.CR_Repository;

/**
 * @author @krishnaKumar 2622807
 *
 */
@Service
public class UtilityService {
	
	private static final Logger log=Logger.getLogger(UtilityService.class.getName());
	
	@Autowired
	private CR_Repository crRepo;
	
	
	/* check 1 : validating user provided details are valid or not */
	public void validateCustomerDetails(CustomerRegistration registerCustomer) {
	 log.warn("Check1 : Validation");	
		if (!nonEmptyCheck(registerCustomer.getFirstName())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide firstName", 1);
		}

		if (!nonEmptyCheck(registerCustomer.getLastName())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide lastName", 1);
		}
		
		if(!nonEmptyCheck(registerCustomer.getAddress())) {
			throw new InvalidCustomerDetials("Invalid", "Please Provide Address", 1);
		}

		if (!panCardValidation(registerCustomer.getPanCardNumber().toUpperCase())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide Valid PanCard", 2);
		}

		if (!adharCardValidation(registerCustomer.getAadharCardNumber())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide Valid AdharCard", 3);
		}

		if (!emailValidation(registerCustomer.getEmailId())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide valid Email", 4);
		}

		if (!phoneNumValidate(registerCustomer.getPhoneNumber())) {
		    throw new InvalidCustomerDetials("Invalid", "Please Provide valid Phone Number", 5);
		}
  }
	
	/* check 2 :checking details already exits in db/app */
	public boolean checkCustomerDetailsExists(CustomerRegistration registerCustomer) {
		CustomerRegistration customerDetailsByEmailId = null;
		CustomerRegistration customerDetailsByAadharCardNumber = null;
		CustomerRegistration customerDetailsByPanCardNumber = null;
		CustomerRegistration customerDetailsByPhoneNumber = null;
		log.warn("Check 2: Validation");
		  	//aadhar 1
		customerDetailsByAadharCardNumber = crRepo.findByAadharCardNumber(registerCustomer.getAadharCardNumber());
			 if(customerDetailsByAadharCardNumber != null) {
				 if(!customerDetailsByAadharCardNumber.getAadharCardNumber().isEmpty()) {
					 log.error("\"AdharCard Already Taken\", \"Please Provide Valid AdharCardDetails\"");
					throw new DetailsAlreadyExits("AdharCard Already Taken", "Please Provide Valid AdharCardDetails");
				}
			 }
			 //pan 2
		customerDetailsByPanCardNumber = crRepo.findByPanCardNumber(registerCustomer.getPanCardNumber());
			 if(customerDetailsByPanCardNumber != null) {
				if(!customerDetailsByPanCardNumber.getAadharCardNumber().isEmpty()) {
					log.error("\"PANCard Already Taken\", \"Please Provide Valid/New PanCard Details\"");
					throw new DetailsAlreadyExits("PANCard Already Taken", "Please Provide Valid/New PanCard Details");
				}
			 }
		  //email 3
		 customerDetailsByEmailId = crRepo.findByEmailId(registerCustomer.getEmailId());
		 	if(customerDetailsByEmailId != null){
			  if(!customerDetailsByEmailId.getEmailId().isEmpty()) {
				  log.error("\"Email Id Already Taken\", \"Please Provide Valid Email\"");
				 throw new DetailsAlreadyExits("Email Id Already Taken", "Please Provide Valid Email");}
			 }
		 //phone 4
		 customerDetailsByPhoneNumber = crRepo.findByPhoneNumber(registerCustomer.getPhoneNumber());
		 	if(customerDetailsByPhoneNumber != null) {
			  if(!customerDetailsByPhoneNumber.getAadharCardNumber().isEmpty()) {
				  log.error("\"PhoneNumber Already Taken\", \"Please Provide Valid/New Number\"");
				throw new DetailsAlreadyExits("PhoneNumber Already Taken", "Please Provide Valid/New Number");
			}
		 }
		return true;
	}
	
	public boolean nonEmptyCheck(String useInput) {
		if(!useInput.isEmpty() && !useInput.isBlank() && useInput != "" ) {
			////1T 1T 1T =1 True
			return true;}
		return false;
		}
    
	public boolean panCardValidation(String panNum) {
		// Regular expression for a valid PAN card number
        String panCardRegex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(panCardRegex);

        // Match the given PAN card number with the pattern
        Matcher matcher = pattern.matcher(panNum);

        // Return true if the PAN card number matches the pattern, else false
        return matcher.matches();
	}

	public boolean adharCardValidation(String aadharCardNumber) {
		// Regular expression for a valid Aadhaar card number
        String aadharCardRegex = "^[2-9]{1}[0-9]{11}$";

        // Return true if the Aadhaar card number matches the pattern, else false
        return aadharCardNumber.matches(aadharCardRegex);	}

	public boolean emailValidation(String email) {
		// Regular expression for a basic email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Return true if the email matches the pattern, else false
        return email.matches(emailRegex);
		
	}

	public boolean phoneNumValidate(String phoneNumber) {
		/** valid 1234567890 , "(123)4567890", "1234567890", "123-456-7890", "(123)456-7890" */ 
		/** Following are invalid phone numbers  
	        "(1234567890)","123)4567890", "12345678901", "(1)234567890",
	        "(123)-4567890", "1", "12-3456-7890", "123-4567", "Hello world"};
        */
		
		String pattern = "^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
		boolean matches = phoneNumber.matches(pattern);
		return matches;
		
	}
	//step 2
	public Map<String, String> provideCustomerDetails(String identityProof) {
		Map<String, String> map=new HashMap<String, String>();
		try {
			final String customerId = generateRandomeNumbers(8); //len 8digits
			final String accountNumber = generateRandomeNumbers(14); //14 digits
			final String DebitCardUrl="http://localhost:8080/api/user/"+customerId+"/DebitCard/";
			final String SetPasswordUrl="http://localhost:8080/api/user/"+customerId+"/SetPassword/";
			map.put("CustomerID", customerId);
			map.put("AccountNumber", accountNumber);
			map.put("DebitCardDetialsUrl", DebitCardUrl);
			map.put("SetNetBankingPasswordUrl", SetPasswordUrl);
		}catch (Exception e) {
			log.error("Error occured during Account Creation :Method: Inside provideCustomerDetails "
					+ ":Class:" +UtilityService.class  +e.getLocalizedMessage());
		}
		return map;
	}

	private String generateRandomeNumbers(int length) {
			int min=1,max=9;
			String randomNumbers = "";
			Random random=new Random();
			for(int i=0;i<length;i++) {
				int randomNum=random.nextInt(max - min + 1)+min;
				randomNumbers=randomNumbers+randomNum;
			}
			return randomNumbers;
		}
	
	public boolean checkPasswordCriteria(String password) {
		String passwordRegex= "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		boolean matches = password.matches(passwordRegex);
		if(matches) {
			log.info("{Password Check}" + HttpStatus.ACCEPTED);
			return true;
		}else {
			//log.info("{Password Check}" + HttpStatus.NOT_ACCEPTABLE);
			throw new InvalidCustomerDetials("Password Must be ! more than 8 characters"
					+"! One UpperCase"
					+"! One LowerCase"
					+"! Atleast 2 digits\n"
					+"! Atleast One Special character",
					"Please Provide valid Password", 8);
		}
	}
		
//
} 
