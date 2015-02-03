package samples.cloudant;

import java.util.List;

import samples.cloudant.pojo.Person;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;

public class Query {

	private void query() {
		
		Database db = getDb();
		
		// create Index
		db.createIndex("hobby","hobby","json",
				new IndexField[]{
                	new IndexField("hobby",SortOrder.asc)
                }
		);
		
		System.out.println("Successfully created index");
		
		List<Person> persons = db.findByIndex("\"selector\" : {\"hobby\" :\"Baseball\"}", Person.class);
		for (Person person : persons) {
			System.out.println(person);
		}
		
		
	}
	
	private Database getDb()
	{
		return new Connect().getDb("sample");
	}
	
	public static void main(String[] args)
	{
		new Query().query();
	}

	

}
