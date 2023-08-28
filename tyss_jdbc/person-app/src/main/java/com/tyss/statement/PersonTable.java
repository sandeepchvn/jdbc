package com.tyss.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonTable {
	
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost/person_db";
		String name="postgres";
		String password="root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,name,password);
			 Statement stm=con.createStatement();
			 stm.execute("create table person(id integer primary key,name character varying not null,email character varying unique,phone bigint unique,password character varying,age integer)");
			// String sql="insert into person values(1,'seeta','seeta@gmail.com',764674,'123',24)";
			 System.out.println("Table is created");
			 con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
