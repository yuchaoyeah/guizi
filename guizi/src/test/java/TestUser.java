

import org.junit.Test;

import guizi.user.dao.UserDao;
import guizi.user.entity.User;

public class TestUser{

	@Test
	public void test() {
		/*User user = new User();
		user.setName("delores");
		user.setAge(20);
		user.setGender(false);*/
		
		UserDao userDao = new UserDao();
		
		/*User me = new User();
		me.setName("voyager");
		me.setAge(24);
		me.setGender(true);
		userDao.save(me);*/
		
		User user = userDao.get("name", "voyager");
		if(user != null) {
			user.setAge(26);
			userDao.save(user);
			
			user = userDao.get("name", "voyager");
		}
		
		System.out.println(user.toString());
	}
}
