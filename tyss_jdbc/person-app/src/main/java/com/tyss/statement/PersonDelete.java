package com.tyss.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDelete {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/person_db?user=postgres&password=root");
		Statement stm=con.createStatement();
		String sql="delete from person where id=2";
		stm.execute(sql);
		System.out.println("deleted successfully");
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
