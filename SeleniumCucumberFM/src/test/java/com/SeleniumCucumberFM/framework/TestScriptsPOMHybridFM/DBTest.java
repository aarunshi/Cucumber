package com.SeleniumCucumberFM.framework.TestScriptsPOMHybridFM;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.SeleniumCucumberFM.framework.helper.DataBase.DataBase;

public class DBTest {

	String sql =" Select * from emp";
	DataBase db = new DataBase();
	
	public void selectDBData() throws ClassNotFoundException, SQLException
	{
		
	ResultSet rs = db.getData(sql);
	//no of columns are 3 in this table one record
	System.out.println(rs.getString(0)+rs.getString(1)+rs.getString(2));
	}
	
	public void InsertDBData() throws ClassNotFoundException, SQLException
	{
		
	 db.insertData(sql);
	
	}
	
	public void updateDBData() throws ClassNotFoundException, SQLException
	{
		
	ResultSet rs = db.updateData(sql);
	//no of columns are 3 in this table one record
	System.out.println(rs.getString(0)+rs.getString(1)+rs.getString(2));
	}
	
}
