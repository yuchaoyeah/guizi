package guizi.user.dao;

import java.util.Map;
import java.util.Map.Entry;

import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import commons.db.MongoDao;
import guizi.user.entity.User;

@Repository
public class UserDao extends MongoDao<User,String>{

}
