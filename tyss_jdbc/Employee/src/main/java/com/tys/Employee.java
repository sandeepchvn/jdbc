package com.tys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/employee";
	String user="postgres";
	String password="root";
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		String sql="INSERT INTO user VALUES(1,'sandeep','sandy@gmail.com','123')";
		//String sql="update emp set name='sandy' where id=1"; // emp is table name
		//String sql="insert into user values(7,'sumeet','sumit@gmail.com','doctor',777,'medical',566.0,'2343')";
		//String sql="delete from emp where id=2";
		Statement stm=con.createStatement();
		stm.execute(sql);
		System.out.println("query is executed");
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
