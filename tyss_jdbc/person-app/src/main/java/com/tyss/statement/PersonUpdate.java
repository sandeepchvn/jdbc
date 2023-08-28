package com.tyss.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonUpdate {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/person_db?user=postgres&password=root");
			Statement stm=con.createStatement();
			String sql="update person set password='rama' where id=1";
			stm.execute(sql);
			System.out.println("updated successfully");
			con.clearWarnings();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
