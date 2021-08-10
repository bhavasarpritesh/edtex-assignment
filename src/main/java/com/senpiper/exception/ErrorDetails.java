package com.senpiper.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
class ErrorDetails {
   //Error Details class
	private Date timeStamp;
	private String email;
	private String details;
}
