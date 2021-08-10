package com.senpiper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.senpiper.exception.EmailAlredyExitsException;
import com.senpiper.model.Center;
import com.senpiper.repository.ICenterRepo;

@Service
public class CenterServiceImpl implements ICenterService {
   
	@Autowired
	private ICenterRepo repo;
	@Override
	
	public Center saveCenter(Center center) {
		if(checkEmailAvalablity(center.getContactEmail()))
		center.setCreatedOn(new Date());
		else
			throw new EmailAlredyExitsException(center.getContactEmail());
		return repo.save(center);
	}

	@Override
	@Nullable
	public List<Center> getAllCenter() {
		return repo.findAll();
	}

	@Override
	public Boolean checkEmailAvalablity(String email) {
	  //checking email is already exits
		Center center=repo.findByContactEmail(email);
		return (center==null)?true:false;
	}

}
