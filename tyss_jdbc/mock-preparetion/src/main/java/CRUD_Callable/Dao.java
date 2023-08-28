package CRUD_Callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class Dao {
	public Connection connection() {
		try {
			Driver d=new Driver();
			DriverManager.registerDriver(d);
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/person_db","postgres","root");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void save() {
		Connection con=connection();
		try {
			CallableStatement cstm=con.prepareCall("call save_person2(?,?)");
		cstm.setInt(1, 12);
		cstm.setString(2, "sandy");
		cstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
