package com.WebServices.BOSWeb.ExceptionHandler;

/**
 * @author 2622807
 *
 */
public class DetailsAlreadyExits extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String Message;
	private String resourceField;
	
	public DetailsAlreadyExits(String message, String resourceField) {
		super();
		Message = message;
		this.resourceField = resourceField;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getResourceField() {
		return resourceField;
	}

	public void setResourceField(String resourceField) {
		this.resourceField = resourceField;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
