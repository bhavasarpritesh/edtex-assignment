package com.edtex.service;

import com.edtex.bean.JobApplication;
import com.edtex.dao.CompanyDaoImpl;
import com.edtex.dao.ICompanyDao;

public class CompanyServiceImpl implements ICompanyService {

	ICompanyDao cdao;
	
	public CompanyServiceImpl() {
		cdao=new CompanyDaoImpl();
	}

	@Override
	public boolean login(String username, String password) {
		return cdao.login(username, password);
	}

	@Override
	public String openJobPosition(JobApplication ja) {
		boolean b=cdao.openJobPosition(ja);
		return b?"postion opened succesfully":"internal problem";
	}

}
