package commons.db;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public abstract class MongoDao {
	private static Morphia morphia;
	private static MongoClient mongoClient;
	protected static Datastore datastore;
	
	{
		morphia = new Morphia();
		mongoClient = new MongoClient("127.0.0.1", 27017);
		datastore = morphia.createDatastore(mongoClient, "guizi");
	}
	
}
