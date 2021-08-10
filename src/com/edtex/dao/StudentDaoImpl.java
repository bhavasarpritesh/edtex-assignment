package com.edtex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edtex.bean.JobApplication;
import com.edtex.bean.Student;

public class StudentDaoImpl implements IStudentDao {

	private static String uname="system";
	private static String pass="pritesh";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	
	private Connection con;
	private PreparedStatement pst;
	private static final String LOGIN_QUERY="SELECT COUNT(*) FROM STUDENTLOGIN WHERE UNAME=? AND PASSWORD=?";
	private static final String APPLY_JOB_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	private static final String AVALIABLE_JOB_QUERY="SELECT POSITION FROM JOBAPPLCATION";
	private static final String AVALIABLE="SELECT DAY,APPLIED FROM JOBAPPLCATION WHERE POSITION=?";
	public StudentDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, uname, pass);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception a)
		{
			
		}
	}
	@Override
	public boolean login(String username, String password) {
		try {
			pst=con.prepareStatement(LOGIN_QUERY);
			pst.setString(1, username);
			pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			int count=rs.getInt(1);
			if(count==1)
			   return true;
			else
				return false;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean applyForJob(Student s) {
		int a = 0;
		try {
			pst=con.prepareStatement(APPLY_JOB_QUERY);
			pst.setString(1, s.getName());
			pst.setInt(2, s.getRoll());
			pst.setFloat(3, s.getSsc());
			pst.setFloat(4, s.getHss());
			 a=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a>0?true:false;
	}
	@Override
	public List<String> avaliableJob()
	{
		List<String> l=new ArrayList<String>();
		try {
			pst=con.prepareStatement(AVALIABLE_JOB_QUERY);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
				l.add(rs.getString(1));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	@Override
	public List<Integer> aviliablity(String poition) {
		List<Integer> l=new ArrayList();
		try {
			pst=con.prepareStatement(AVALIABLE);
			pst.setString(1, poition);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				l.add(rs.getInt(1));
				l.add(rs.getInt(2));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public void update(String a) {
		try {
			int  v=0;
			pst=con.prepareStatement("update JOBAPPLCATION set APPLIED=? where POSITION=?");
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select APPLIED from JOBAPPLCATION where POSITION='"+a+"'");
		    if(rs.next())
		    	v=rs.getInt(1);
		    pst.setInt(1, ++v);
		    pst.setString(2, a);
		    pst.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
