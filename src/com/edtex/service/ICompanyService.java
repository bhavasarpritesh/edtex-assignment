package com.edtex.service;

import com.edtex.bean.JobApplication;

public interface ICompanyService {
	boolean login(String username,String password);
    String openJobPosition(JobApplication ja);
    

}
