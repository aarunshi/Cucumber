 package com.SeleniumCucumberFM.framework.helper.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

	
	public Statement getStatement() throws SQLException, ClassNotFoundException
	{
		String Driver = "com,mysql.cj.jdbc.driver";
		//currently server is local and databasename is cutomer
		String connString = "jdbc.mysql://localhost3306/Customer";
		String username ="root";
		String password="password";
		//register the driver
		Class.forName(Driver);
		//set connection
		Connection con = DriverManager.getConnection(connString,username,password);
		//get Statement
		Statement stmt = con.createStatement();
		return stmt;
	}
	public void insertData(String query) throws ClassNotFoundException, SQLException
	{
		Statement st = getStatement();
		st.executeUpdate(query);
		
	}
	
	public ResultSet updateData(String query) throws ClassNotFoundException, SQLException
	{
		Statement st = getStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	
	
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException
	{
		Statement st = getStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
}
 