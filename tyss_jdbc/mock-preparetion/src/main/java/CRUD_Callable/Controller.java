package CRUD_Callable;

import java.sql.Statement;

public class Controller {

	public static void main(String[] args) {
		Dao dao=new Dao();
		dao.save();
		System.out.println("saved------!");
		
	}
}
