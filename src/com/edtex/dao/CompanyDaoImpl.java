package com.edtex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.edtex.bean.JobApplication;

public class CompanyDaoImpl implements ICompanyDao {

	private static String uname="system";
	private static String pass="pritesh";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";

	private Connection con;
	private PreparedStatement pst;
	private static final String LOGIN_QUERY="SELECT COUNT(*) FROM COMPANYLOGIN WHERE UNAME=? AND PASSWORD=?";
	private static final String ADD_JOB_QUERY="INSERT INTO JOBAPPLCATION VALUES(?,?,?,?,?)";
	
	public CompanyDaoImpl() {
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
	public boolean openJobPosition(JobApplication ja) {
		boolean status=false;
		try {
			pst=con.prepareStatement(ADD_JOB_QUERY);
			pst.setString(1,ja.getCompanyName());
			pst.setString(2,ja.getAddress());
			pst.setString(3,ja.getPosition());
			pst.setInt(4,ja.getDay());
			pst.setInt(5,0);
			int count=pst.executeUpdate();
		    if(count>0)
		    	status=true;
		    else
		    	status=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
