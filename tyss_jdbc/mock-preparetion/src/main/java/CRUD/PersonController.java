package CRUD;

public class PersonController {
	public static void main(String[] args) {
		PersonDao dao=new PersonDao();
		//dao.save();
		//dao.update();
		dao.find();
		//dao.delete();
		System.out.println("saved------!");
	}
}
