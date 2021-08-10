package com.edtex.service;

import java.util.List;

import com.edtex.bean.JobApplication;
import com.edtex.bean.Student;
import com.edtex.dao.CompanyDaoImpl;
import com.edtex.dao.ICompanyDao;
import com.edtex.dao.IStudentDao;
import com.edtex.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {

	IStudentDao cdao;
	
	public StudentServiceImpl() {
		cdao=new StudentDaoImpl();
	}

	@Override
	public boolean login(String username, String password) {
		return cdao.login(username, password);
	}

	public void update(String aa)
	{
		cdao.update(aa);
	}

	@Override
	public String applyForJob(Student s,String aa) {
		update(aa);
		return cdao.applyForJob(s)?"Apply Succesfully":"Internal problem";
	}

	@Override
	public List<String> avaliableJob() {
		
		return cdao.avaliableJob();
	}

	@Override
	public boolean aviliablity(String poition) {
		List<Integer>l= cdao.aviliablity(poition);
		if(l.get(0)==1 && l.get(1)<=5)
		return true;
		if(l.get(0)==2 && l.get(1)<=8)
		return true;	
		if(l.get(0)==3 && l.get(1)<=10)
		return true;
		return false;
	}

}
