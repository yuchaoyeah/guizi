package guizi.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guizi.user.dao.UserDao;
import guizi.user.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User getUserByName(String name) {
		return userDao.get("name", name);
	}
}
