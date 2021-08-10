package com.senpiper.exception;

public class EmailAlredyExitsException extends RuntimeException {
     //custom Exception class 
	public EmailAlredyExitsException(String message) {
		super(message);
		
	}
   
}
