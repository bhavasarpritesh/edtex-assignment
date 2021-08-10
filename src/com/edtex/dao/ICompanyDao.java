package com.edtex.dao;

import com.edtex.bean.JobApplication;

public interface ICompanyDao {
      boolean login(String username,String password);
      boolean openJobPosition(JobApplication ja);
}
