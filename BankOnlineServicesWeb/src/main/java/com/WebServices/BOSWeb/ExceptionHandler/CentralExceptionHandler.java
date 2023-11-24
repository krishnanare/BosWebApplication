package com.WebServices.BOSWeb.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CentralExceptionHandler {

	 // handle specific exceptions
    @ExceptionHandler(InvalidCustomerDetials.class)
    public ResponseEntity<ErrorDetials> handleResourceNotFoundException(InvalidCustomerDetials exception,
                                                                        WebRequest webRequest){
        ErrorDetials errorDetails= new ErrorDetials(new Date(), exception.getFieldName(),
        		exception.getResourceName(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DetailsAlreadyExits.class)
    public ResponseEntity<ErrorDetials> handleDetailsAlreadyExitsException(DetailsAlreadyExits exception,
    		WebRequest webRequest){
    	ErrorDetials errorDetails= new ErrorDetials(new Date(), exception.getResourceField(), 
    			exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
