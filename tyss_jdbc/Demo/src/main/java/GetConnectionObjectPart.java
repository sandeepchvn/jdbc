import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionObjectPart {
//	private static String url = "jdbc:postgresql://localhost:5432/employee";

	public static void main(String[] args) {
		try {
			
			FileInputStream fileInputStream = new FileInputStream("demo.properties");
			
			Properties p = new Properties();
			p.load(fileInputStream);
			
			String driverName=p.getProperty("driverClassPath");//[getProperty takes the key and retuns the 
			//value associated with it]
			Class.forName(driverName);
			
//			String user = properties.getProperty("user") ;[we can also pass user with out using load method]
//			System.out.println(user);
			
			String URL_recived=p.getProperty("URL");
			Connection con = DriverManager.getConnection(URL_recived, p);
			
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
