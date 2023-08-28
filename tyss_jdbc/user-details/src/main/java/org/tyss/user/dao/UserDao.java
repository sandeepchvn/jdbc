package org.tyss.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public void saveUser(int id, String name, long phone, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/user_db?user=postgres&password=root");
			String sql = "insert into user1 values(?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setLong(3, phone);
			pstm.setString(4, password);
			pstm.executeUpdate();
			System.out.println("record inserted");
			con.clearWarnings();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(int id, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/user_db?user=postgres&password=root");
			String sql = "update user1 set password=? where id=?";
			if (fetchUser(id) == 1) {
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setString(1, password);
				pstm.setInt(2, id);
				pstm.executeUpdate();
				System.out.println("password updated successfully");
			} else
				System.out.println("id is not present");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int fetchUser(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_db?user=postgres&password=root");
			
			String sql = "select * from user1 where id=?";//select * from \"user\" where id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println("id-" + rs.getInt(1));//column number
				System.out.println("name-" + rs.getString(2));
				System.out.println("phone-" + rs.getLong(3));
				System.out.println("password-" + rs.getString(4));
				System.out.println("--------------------------------");
				if (id == rs.getInt(1)) {
					return 1;
				}
			}

			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void deleteUser(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/user_db?user=postgres&password=root");
			String sql = "delete from user1 where id=?";
			// UserDao dao = new UserDao();
			if (fetchUser(id) == 1) {
				PreparedStatement pstm = con.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.executeUpdate();
				System.out.println("record deleted successfully");
			} else
				System.out.println("id is wrong");
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
