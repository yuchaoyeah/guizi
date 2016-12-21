package commons.db;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import commons.utils.ReflectionUtils;
import commons.utils.SpringContextHolder;

public class MongoDao<T, K extends Serializable> {
	private Class<T> entityClass;
	protected BasicDAO<T, K> morphiaDao;
	
	public MongoDao() {
		this.entityClass = ReflectionUtils.getParamClassType(getClass());
		MongoFactory mongoFactory = SpringContextHolder.getBean(MongoFactory.class);
		MongoClient mongoClient = mongoFactory.getMongoClient();
		System.out.println(mongoClient==null?"------mongoClient is null!":"");
		Morphia morphia = mongoFactory.getMorphia();
		System.out.println(mongoClient==null?"------morphia is null!":"");
		String dbName = mongoFactory.getDbName();
		System.out.println(mongoClient==null?"------dbName is null!":"");
		morphiaDao = new BasicDAO<T, K>(entityClass, mongoClient, morphia, dbName);
		morphiaDao.ensureIndexes();
	}
	
	public Query<T> createQuery() {
		return morphiaDao.createQuery();
	}
	
	public T get(K id) {
		return (T) morphiaDao.get(id);
	}
	
	public T get(String key,Object value) {
		return createQuery().field(key).equal(value).get();
	}
	
	public T get(Map<String,Object> props) {
		Query<T> query = createQuery();
		for(Entry<String,Object> entry : props.entrySet()) {
			query.field(entry.getKey()).equal(entry.getValue());
		}
		return query.get();
	}
}
