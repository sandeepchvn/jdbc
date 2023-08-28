package com.tyss.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonInsert {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/person_db?user=postgres&password=root");
			Statement stm=con.createStatement();
			String sql="insert into person values(2,'hhsh','seeta@mail.com',76656,'seeta@123',24)";
			stm.execute(sql);
			System.out.println("data inserted into person table");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
