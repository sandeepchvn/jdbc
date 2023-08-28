package com.tyss.functions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Function_demo {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root"))
	{
		CallableStatement cstm=con.prepareCall("select count_by_gender(?)");
		cstm.setString(1, "male");
		ResultSet rs=cstm.executeQuery();
		rs.next();
		int result =rs.getInt(1);
		System.out.println("count is "+result);
		con.close();
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
}
}
