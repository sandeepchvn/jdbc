package com.tyss;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class DB_MetaData {
public static void main(String[] args) {
	Driver d= new  Driver();
	try {
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root");
		DatabaseMetaData dm= con.getMetaData();
	String un=	dm.getUserName();
	System.out.println("user name--"+un);
	String uv=	dm.getDriverVersion();
	System.out.println("Driver version--"+uv);
	String unm=	dm.getDriverName();
	System.out.println("Driver name--"+unm);
	boolean r=dm.supportsOuterJoins();
	System.out.println("supports outer join--"+r);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
