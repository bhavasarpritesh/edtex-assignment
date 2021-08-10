package com.edtex.test;

import java.util.List;
import java.util.Scanner;

import com.edtex.bean.JobApplication;
import com.edtex.bean.Student;
import com.edtex.service.CompanyServiceImpl;
import com.edtex.service.ICompanyService;
import com.edtex.service.IStudentService;
import com.edtex.service.StudentServiceImpl;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("welcome to placement system");
		System.out.println("1 : Company   2: Student");
		int choice=sc.nextInt();
		if(choice==1) {
			ICompanyService cs=new CompanyServiceImpl();
			System.out.println("enter username");
			String uname=sc.next();
			System.out.println("enter password");
			String password=sc.next();
			if(cs.login(uname, password)) {
				System.out.println("enter company name");
				String name=sc.next();
				System.out.println("enter company addr");
				String addr=sc.next();
				System.out.println("enter looking position");
				String position=sc.next();
				System.out.println("enter day");
				int day=sc.nextInt();
				JobApplication ja=new JobApplication();
				ja.setCompanyName(name);
				ja.setAddress(addr);
				ja.setPosition(position);
				ja.setDay(day);
				String s=cs.openJobPosition(ja);
				System.out.println(s);
			}
			else {
				System.out.println("wrong username/password");  
			}
			
		}
		else if(choice==2)
		{
			IStudentService ss=new StudentServiceImpl();
			System.out.println("enter username");
			String uname=sc.next();
			System.out.println("enter password");
			String password=sc.next();
			if(ss.login(uname, password)) {
			    List<String> l= ss.avaliableJob();
			    int count=1;
			    for(String item : l)
			    {
			    	
			    	System.out.println(count+" "+item);
			    	++count;
			    	
			    }
			    System.out.println("chose for apply");
			    int choise=sc.nextInt();
			    boolean b=ss.aviliablity(l.get(choise-1));
			    if(b)
			    {
			    	System.out.println("enter student name");
					String name=sc.next();
					System.out.println("enter roll number");
					int roll=sc.nextInt();
					System.out.println("enter ssc mark");
					Float ssc=sc.nextFloat();
					System.out.println("enter hsc mark");
					Float hsc=sc.nextFloat();
					Student s=new Student();
					s.setName(name);
					s.setRoll(roll);
					s.setSsc(ssc);
					s.setHss(hsc);
					System.out.println(ss.applyForJob(s,l.get(choise-1)));
				
			    }
			}
			else {
				System.out.println("wrong username/password");  
			}
			
		}
		else
		{
			System.out.println("plz select right option");
		}
		

	}

}
