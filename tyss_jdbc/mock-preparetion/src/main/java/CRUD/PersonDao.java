package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class PersonDao {

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
			PreparedStatement pstm=con.prepareStatement("insert into person2 values(?,?)");
			pstm.setInt(1, 102);
			pstm.setString(2, "sandeep");
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void update() {
		Connection con=connection();
		try {
			PreparedStatement pstm=con.prepareStatement("update person2 set name=?");
			pstm.setString(1, "sumeep");
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void find() {
		Connection con=connection();
		try {
			Statement stm=con.createStatement();
			stm.execute("select * from person2");
			ResultSet s=stm.getResultSet();
//			PreparedStatement pstm=con.prepareStatement("select * from person2");
//			ResultSet s=pstm.executeQuery();
			while(s.next()) {
				System.out.println(s.getInt(1));
				System.out.println(s.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		Connection con=connection();
		try {
			PreparedStatement pstm=con.prepareStatement("delete from person2 where id=?");
			pstm.setInt(1, 102);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
