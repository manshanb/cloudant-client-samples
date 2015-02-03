package samples.cloudant;

import samples.cloudant.pojo.Person;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

public class UpdateDocument {
	
	public void update()
	{
		Database db = getDb();

		Person person = db.find(Person.class,"mangesh");
		
		person.setHobby("Baseball");
		
		Response r =db.update(person);			
		
		System.out.println("UPDATE SUCCESSFUL. Id: " + r.getId() + ", rev: " + r.getRev());
	}
	
	private Database getDb()
	{
		return new Connect().getDb("sample");
	}
	
	public static void main(String[] args)
	{
		new UpdateDocument().update();
	}

}
