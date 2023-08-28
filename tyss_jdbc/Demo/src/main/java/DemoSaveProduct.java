import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoSaveProduct {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/shop";
	String user="postgres";
	String password="root";
	try {
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url, user, password);
		String sql="INSERT INTO product VALUES(1,'LG',23330.4)";
		Statement stm=con.createStatement();
		stm.execute(sql);
		System.out.println(con);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
