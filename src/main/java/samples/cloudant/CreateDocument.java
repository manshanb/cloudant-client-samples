package samples.cloudant;

import samples.cloudant.pojo.Person;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;

public class CreateDocument {

	public void create(){
		
		Database db = getDb();
						
		Person person = new Person();
		person.set_id("mangesh");
		person.setName("Mangesh S");
		person.setCity("Bangalore");
		person.setHobby("Soccer");
		
		Response r = db.post(person);
				
		System.out.println("Person created successfully. Id: " + r.getId() + ", rev: " + r.getRev());
		
	}
	
	private Database getDb()
	{
		return new Connect().getDb("sample");
	}
	
	public static void main(String[] args)
	{
		new CreateDocument().create();
	}
}
