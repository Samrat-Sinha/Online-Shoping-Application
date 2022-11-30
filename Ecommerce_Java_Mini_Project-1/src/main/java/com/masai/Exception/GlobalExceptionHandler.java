package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.masai.Model.GlobalErrorDetails;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<GlobalErrorDetails> AdminDetailsInvalidHandler(AdminException ae,WebRequest req){
		GlobalErrorDetails err = new GlobalErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<GlobalErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<GlobalErrorDetails> CustomerDetailsInvalidHandler(CustomerException ce,WebRequest req){
		GlobalErrorDetails err = new GlobalErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<GlobalErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<GlobalErrorDetails> ProductDetailsInvalidHandler(ProductException pe,WebRequest req){
		GlobalErrorDetails err = new GlobalErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<GlobalErrorDetails>(err,HttpStatus.BAD_GATEWAY);
	}
	
	
}
