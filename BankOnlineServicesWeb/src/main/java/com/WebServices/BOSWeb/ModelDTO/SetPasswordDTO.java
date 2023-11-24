package com.WebServices.BOSWeb.ModelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 2622807
 * to set password user must provide customerID and Newpassword (based on rules)
 */
@Entity
@Table(name="Customer_Password")
public class SetPasswordDTO {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String customerId;
 private String password;
 @Transient
 private String Message;
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public SetPasswordDTO(Long id, String CustomerId, String password,String message) {
	super();
	this.Message=message;
	this.id = id;
	customerId = CustomerId;
	this.password = password;
}
public SetPasswordDTO() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String CustomerId) {
	customerId = CustomerId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 
}
