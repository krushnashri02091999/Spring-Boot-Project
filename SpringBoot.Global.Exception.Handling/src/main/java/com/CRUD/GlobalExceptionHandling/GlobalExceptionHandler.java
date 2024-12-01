package com.CRUD.GlobalExceptionHandling;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> productNotFoundException(ProductNotFoundException pnfe, HttpServletRequest request){
		ErrorResponse error=new ErrorResponse();
//		ErrorResponse error1=new ErrorResponse(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND,pnfe.getMessage(),new Date(),request.getRequestURI());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError(HttpStatus.NOT_FOUND);
		error.setMsg(pnfe.getMessage());
		error.setDate(new Date());
		error.setPath(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	};
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> arithmaticExceptionHandler(ArithmeticException e){
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	};
}
