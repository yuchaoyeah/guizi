package guizi.user.dao;

import java.util.Map;
import java.util.Map.Entry;

import org.mongodb.morphia.query.Query;

import commons.db.MongoDao;
import guizi.user.entity.User;

public class UserDao extends MongoDao{

	public void save(User user) {
		datastore.save(user);
	}
	
	public User get(String id) {
		Query<User> query = datastore.createQuery(User.class);
		query.field("id").equal(id);
		return query.get();
	}
	
	public User get(Map<String,Object> props) {
		if(props == null || props.isEmpty()) {
			return null;
		}
		Query<User> query = datastore.createQuery(User.class);
		for(Entry<String,Object> entry : props.entrySet()) {
			query.field(entry.getKey()).equal(entry.getValue());
		}
		return query.get();
	}
	
	public User get(String key,Object value) {
		if(key == null || value == null) {
			return null;
		}
		Query<User> query = datastore.createQuery(User.class);
		query.field(key).equal(value);
		return query.get();
	}
}
