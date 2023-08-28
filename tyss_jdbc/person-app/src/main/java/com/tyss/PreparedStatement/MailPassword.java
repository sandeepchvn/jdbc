package com.tyss.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MailPassword {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/person_db?user=postgres&password=root");
			String sql = "select * from person where email=? and password=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.println("enter your email and password");
			String email = sc.next();
			String password = sc.next();
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println("id " + rs.getInt("id"));
				System.out.println("name " + rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));
				System.out.println("----------------------------");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
