package driver;

import database.DataBaseHelper;
import java.util.ArrayList;

public class Driver {
	
	public static void main(String[] args) {
		DataBaseHelper.in("insert into User (name) values ('Snow')");
		ArrayList<String> arrayList = DataBaseHelper.out("select name from User","name");
		for(int i=0;i<arrayList.size();i++)
			System.out.println(arrayList.get(i));
	}
}