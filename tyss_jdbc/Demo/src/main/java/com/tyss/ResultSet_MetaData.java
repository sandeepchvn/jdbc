package com.tyss;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class ResultSet_MetaData {
	public static void main(String[] args) {
		Driver d = new Driver();
		try {
			DriverManager.registerDriver(d);
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from product");
			ResultSetMetaData dm = rs.getMetaData();
			String un = dm.getColumnName(3);
			System.out.println("column name---" + un);
			 
			int cnum=dm.getColumnCount();
			System.out.println("column conut is "+cnum);
			
			String t=dm.getColumnTypeName(3);
			System.out.println("type is--"+t);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
