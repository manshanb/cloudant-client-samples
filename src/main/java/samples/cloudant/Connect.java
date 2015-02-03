package samples.cloudant;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

public class Connect {
	
	private CloudantClient cloudantClient = null;
	
	private String password = System.getenv().get("PASSWORD");
	

	public CloudantClient connect() {		
		//CREATE CLOUDANT CLIENT
		cloudantClient =  new CloudantClient("manshanb", "manshanb", password);
		
		System.out.println("CONNECTION SUCCESSFUL - " + cloudantClient.getBaseUri());
		
		return cloudantClient;
	}
	
	
	public Database getDb(String dbName) {
		
		// use a database
		Database db = connect().database("sample", true);
		
		System.out.println("Database available - " + db.getDBUri());
		
		return db;
	}
	
	

	public static void main(String[] args) {
		
		new Connect().getDb("sample");

	}

}
