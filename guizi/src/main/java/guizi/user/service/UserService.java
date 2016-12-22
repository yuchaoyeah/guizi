package guizi.user.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guizi.user.dao.UserDao;
import guizi.user.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User get(String id) {
		return userDao.get(id);
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public User getUserByName(String name) {
		return userDao.get("name", name);
	}
	
	public User getUserByProperties(Map<String,Object> map) {
		return userDao.get(map);
	}
	
	public User getUserByProperty(String key,Object value) {
		return userDao.get(key, value);
	}
}
