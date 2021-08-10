package com.edtex.dao;

import java.util.List;


import com.edtex.bean.Student;

public interface IStudentDao {
      boolean login(String username,String password);
      boolean applyForJob(Student s);
      List<String> avaliableJob();
      List<Integer> aviliablity(String poition);
      void update(String a);
}
