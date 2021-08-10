package com.senpiper.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senpiper.model.Center;
import com.senpiper.service.ICenterService;

@RestController
@RequestMapping("apis")
public class FrontController {
	@Autowired
	private ICenterService service;
    @PostMapping(value ="/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Center> addCenter(@Valid @RequestBody Center center){
    	Center savedCenter=service.saveCenter(center);
    	return new ResponseEntity<Center>(savedCenter, HttpStatus.CREATED);
    	//post request for creating new Center Resource 
	}
    @GetMapping(value ="/getall")
   	public ResponseEntity<List<Center>> addCenter(){
   		return ResponseEntity.ok(service.getAllCenter());
   		//getting all record
   	}
}
