package com.tyss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeacherTransaction {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
			String sql1 = "INSERT INTO teacher VALUES(101,'sheela','female',24,s@gmail.com,888,B+)";
			String sql2 = "Insert into id_card values(101,sheela,888,B+)";
			String sql3 = "insert into lib_card values(101,'sheela','s@gmail.com');";
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
