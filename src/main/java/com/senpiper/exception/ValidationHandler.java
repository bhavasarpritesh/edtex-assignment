package com.senpiper.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class ValidationHandler  extends ResponseEntityExceptionHandler{
	//custom exception handler class
	@ResponseBody
	@ExceptionHandler(EmailAlredyExitsException.class)
	public ResponseEntity<ErrorDetails> emailAlredyExits(EmailAlredyExitsException ex){
		
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(),ex.getMessage(),"Email Already Exits"),HttpStatus.BAD_REQUEST);
		
	}
	    @ResponseBody
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorDetails> internalError(Exception ex){
			
			return new ResponseEntity<ErrorDetails>(new ErrorDetails(new Date(),ex.getMessage(),"Internal Server Problem"),HttpStatus.BAD_REQUEST);
			
		}
	    @Override
	    @ResponseBody
	   
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers,
	                                                                  HttpStatus status, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", status.value());

	        //Get all errors
	        List<String> errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());

	        body.put("errors", errors);

	        return new ResponseEntity<>(body, headers, status);

	    }
		  

}
