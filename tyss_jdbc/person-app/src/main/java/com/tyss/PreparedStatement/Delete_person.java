package com.tyss.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_person {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/person_db?user=postgres&password=root");
		String sql="delete from person where id=2";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.executeUpdate();
		System.out.println("record deleted");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
