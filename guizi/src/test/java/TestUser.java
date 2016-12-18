

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
		
		User user = new UserDao().get("name", "delores");
		System.out.println(user.toString());
	}
}
