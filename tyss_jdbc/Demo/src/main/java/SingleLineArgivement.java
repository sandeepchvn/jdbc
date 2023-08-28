import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;
//creating connectin by passing single string argument
public class SingleLineArgivement {
	private static String url="jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";
	public static void main(String[] args) {
		try {
//			Driver d=new Driver();
//			DriverManager.registerDriver(driver); 2nd way of loading and registering the Driver
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection(url);
			System.out.println("connection eshtablished");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
