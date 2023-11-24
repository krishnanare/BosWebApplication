package com.WebServices.BOSWeb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebServices.BOSWeb.ModelDTO.CustomerRegistration;


public interface CR_Repository extends JpaRepository<CustomerRegistration, Long>{
	
	CustomerRegistration findByEmailId(String EmailId);
	CustomerRegistration findByPhoneNumber(String phoneNum);
	CustomerRegistration findByPanCardNumber(String panNum);
	CustomerRegistration findByAadharCardNumber(String aadharNum);
}
