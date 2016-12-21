package commons.db;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.Mapper;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoFactory implements InitializingBean, DisposableBean{
	private static String host;
	private static int port;
	private static String mapPackage;
	private static String dbName;
	
	private static Morphia morphia;
	private static MongoClient mongoClient;
	protected static Datastore datastore;
	
	public void buildMongoFactory() {
//		host = "127.0.0.1";
//		port = 27017;
//		mapPackage = "guizi";
//		dbName = "guizi";
		morphia = new Morphia();
		intiMongoClient();
		datastore = createDatastore();
	}
	
	private static void intiMongoClient() {
		ServerAddress addr = new ServerAddress(host, port);
		mongoClient = new MongoClient(addr);
	}
	
	private static Datastore createDatastore() {
		morphia.mapPackage(mapPackage);
		Mapper mapper = morphia.getMapper();
		Datastore ds = morphia.createDatastore(mongoClient, mapper, dbName);
		ds.ensureIndexes(true);
		return ds;
	}
	
	public static Morphia getMorphia() {
		return morphia;
	}

	public static MongoClient getMongoClient() {
		return mongoClient;
	}

	public static Datastore getDatastore() {
		return datastore;
	}

	public static String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public static int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public static String getMapPackage() {
		return mapPackage;
	}
	public void setMapPackage(String mapPackage) {
		this.mapPackage = mapPackage;
	}
	public static String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public void destroy() throws Exception {
		this.mongoClient.close();
	}

	public void afterPropertiesSet() throws Exception {
		buildMongoFactory();
	}
}
