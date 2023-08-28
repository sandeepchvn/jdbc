import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		try (Connection con = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/shop?user=postgres&password=root"))
		{
			Statement stm=con.createStatement();
			String query1="insert into product values(5,'latop',233.4),(6,'phne',733.4)";
			stm.addBatch(query1);
			String query3="insert into product values(7,'pn',333.4)";
			stm.addBatch(query3);
			int[] c=stm.executeBatch();
			for (int i : c) {
				System.out.println(i);//it will give number of rowrs effected in each query
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
