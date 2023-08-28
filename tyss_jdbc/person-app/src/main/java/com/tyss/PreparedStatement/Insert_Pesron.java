package com.tyss.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Pesron {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/person_db?user=postgres&password=root");
			//org.postgresql.util.PSQLException: FATAL: password authentication failed for user "sande" == if you mistake in user name and password
			String sql="insert into person values(3,'sandeep','sandeep@gmail.com',4747,'sandy123',24)";
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.execute();
			System.out.println("data is inserted");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
