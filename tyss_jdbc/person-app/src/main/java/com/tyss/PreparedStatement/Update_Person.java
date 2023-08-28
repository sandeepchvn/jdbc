package com.tyss.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Person {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/person_db?user=postgres&password=root");
		String sql="update person set name='sumeet' where id=3";
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.executeUpdate();
		System.out.println("updated successufully");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}
