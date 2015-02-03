package samples.cloudant;

import java.util.List;

import samples.cloudant.pojo.Person;

import com.cloudant.client.api.Database;

public class GetAllDocuments {

	public void get()
	{
		//Get db
		Database db = getDb();
		
		//Get all documents
		List<Person> allPersons = db.view("_all_docs")
				.includeDocs(true)
				.query(Person.class); 
		
		for (Person person : allPersons ) {
			System.out.println(person);
		}
		
				
	}

	private Database getDb()
	{
		return new Connect().getDb("sample");
	}
	
	public static void main(String[] args)
	{
		new GetAllDocuments().get();
	}
}