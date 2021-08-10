package com.senpiper.service;

import java.util.List;

import com.senpiper.model.Center;

public interface ICenterService {
	Center saveCenter(Center center);
    List<Center> getAllCenter();
    Boolean checkEmailAvalablity(String email);
}
