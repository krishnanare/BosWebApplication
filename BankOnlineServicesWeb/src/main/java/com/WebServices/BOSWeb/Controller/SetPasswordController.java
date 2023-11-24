package com.WebServices.BOSWeb.Controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServices.BOSWeb.BosWebApplication;
import com.WebServices.BOSWeb.ExceptionHandler.InvalidCustomerDetials;
import com.WebServices.BOSWeb.ModelDTO.SetPasswordDTO;
import com.WebServices.BOSWeb.Repository.SetPasswordRepo;
import com.WebServices.BOSWeb.ServicesImpl.UtilityService;

/**
 * @author @Krishnakumar @2622807
 *
 */
@RestController
@RequestMapping("api/user/")
public class SetPasswordController {
	
	@Autowired
	private UtilityService util;
	
	@Autowired
	private SetPasswordRepo pwdRepo;
	
	private static final Logger log=Logger.getLogger(BosWebApplication.class.getName());
	
	@PostMapping("/{customerId}/SetPassword/")
	public SetPasswordDTO setPassword(@PathVariable("customerId") String Customerid,@RequestBody SetPasswordDTO pwd) {
		boolean checkPasswordCriteria = util.checkPasswordCriteria(pwd.getPassword());
			if(checkPasswordCriteria) {
				//save
				pwd.setCustomerId(Customerid);
				pwd.setMessage("Password Set Successfully");
				pwdRepo.save(pwd);
				log.info("save password for " +Customerid );
				 return pwd;
			}else {
				throw new InvalidCustomerDetials("Password Criteria Not Matched", 
						"One Upper/Lower/Two Digits/Special Case", 8); 
			}
		}
	
	@PutMapping("/{customerId}/SetPassword/")
	public SetPasswordDTO updatePassword(@PathVariable("customerId") String Customerid,@RequestBody SetPasswordDTO pwd) {
		SetPasswordDTO findByCustomerId = checkCustomerExisted(Customerid);
		String oldPassword = findByCustomerId.getPassword();
		String NewPassword=pwd.getPassword();
			if(!oldPassword.equals(NewPassword) && util.checkPasswordCriteria(NewPassword)) {
				pwd.setId(findByCustomerId.getId());
				pwd.setCustomerId(Customerid);
				pwd.setMessage("Password Set Successfully");
				pwd.setPassword(pwd.getPassword());
				pwdRepo.save(pwd);
			return pwd;
			}else {
				log.error("Password Entered was Doesnot Same As Old Password ");
				throw new InvalidCustomerDetials("Please Provide Valid Password", 
						"Password Entered was Doesnot Same As Old Password", 8);
		}
	}

	private SetPasswordDTO checkCustomerExisted(String Customerid) {
		SetPasswordDTO findByCustomerId = null;
		try {
			//check the existing pw , which is same as current pw
			 log.debug("find customer with " + Customerid + " : For Validating Password");
			 findByCustomerId = pwdRepo.findByCustomerId(Customerid);
		return findByCustomerId;
		}catch (Exception e) {
			log.error("Customer Doesnot Exits With " + Customerid);
			throw new InvalidCustomerDetials("Customer Doesnot Exits" ,"findByCustomerId", Customerid);
		}
	}

}
