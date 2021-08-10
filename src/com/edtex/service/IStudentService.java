package com.edtex.service;

import java.util.List;

import com.edtex.bean.JobApplication;
import com.edtex.bean.Student;

public interface IStudentService {
	boolean login(String username,String password);
	String applyForJob(Student s,String aa);
    List<String> avaliableJob();
   boolean aviliablity(String poition);

}
