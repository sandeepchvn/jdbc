package com.tyss.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch_Person {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/person_db?user=postgres&password=root");
		String sql="select * from person";
		PreparedStatement pstm=con.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			System.out.println("id "+rs.getInt("id"));
			System.out.println("name "+rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			System.out.println("----------------------------");
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
