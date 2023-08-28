package com.tys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FetchEmployee {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/employee";
	String user="postgres";
	String password="root";
	
	try {
		//step 1
		Class.forName("org.postgresql.Driver");
		//step 2
		Connection con=DriverManager.getConnection(url,user,password);
		
		String sql="select * from emp";
		
		//step 3
		Statement stm=con.createStatement();
		
		//step 4
		ResultSet rs= stm.executeQuery(sql);
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String desg=rs.getString(4);
			long phone=rs.getLong(5);
			String dept=rs.getString(6);
			double salary=rs.getDouble(7);
			String password1=rs.getString(8);
			System.out.println("id -"+id);
			System.out.println("name -"+name);
			System.out.println("email -"+email);
			System.out.println("desg -"+desg);
			System.out.println("phone -"+phone);
			System.out.println("dept -"+dept);
			System.out.println("salary -"+salary);
			System.out.println("password1 -"+password1);
			System.out.println("--------------------------------");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
