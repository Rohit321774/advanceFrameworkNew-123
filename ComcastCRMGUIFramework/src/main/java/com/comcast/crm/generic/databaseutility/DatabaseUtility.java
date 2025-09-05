package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDatabaseConnection(String url,String Username,String Password) throws SQLException {
		try {
		Driver driver=new Driver();
		   DriverManager.registerDriver(driver);
		   
		         conn =DriverManager.getConnection(url,Username,Password);
		}
		catch(Exception e)
		{}
	}
	public void getDatabaseConnectionOg() throws SQLException {
		try {
		Driver driver=new Driver();
		   DriverManager.registerDriver(driver);
		   
		         conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		}
		catch(Exception e)
		{}
	}
		public void closeDatabase() throws SQLException {
			conn.close();
			
		}
		
		public ResultSet excuteSqlQuery(String Query) throws SQLException {
			ResultSet resultset = null;
			try {
			        Statement state=conn.createStatement();
			          resultset=state.executeQuery(Query);
			          
		}
			catch(Exception e)
			{}
			return resultset;
		}
		
		
			public int excuteNonSqlQuery(String Query) throws SQLException {
				int result=0;
				try {
				        Statement state=conn.createStatement();
				          result=state.executeUpdate(Query);
				          
			}
				catch(Exception e)
				{}
				return result;
			
			
		
}
}

