package com.tyss.create_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveTableRecords {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root"))
	{
		CallableStatement cstm=con.prepareCall("call create_teacher_records(?,?,?,?,?,?,?)");
		cstm.setInt(1, 3);
		cstm.setString(2, "deva");
		cstm.setString(3, "male");
		cstm.setInt(4, 24);
		cstm.setString(5, "deva@gamil.com");
		cstm.setString(6,"94874");
		cstm.setString(7, "o+");
		cstm.addBatch();
		
		cstm.setInt(1, 4);
		cstm.setString(2, "deva");
		cstm.setString(3, "male");
		cstm.setInt(4, 24);
		cstm.setString(5, "deva@gamil.com");
		cstm.setString(6,"94874");
		cstm.setString(7, "o+");
		cstm.addBatch();
		
		int[] c=cstm.executeBatch();
		for (int i : c) {
			System.out.println(i);
		}
		//cstm.execute();
		System.out.println("stored in to procedure");
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
}
}
