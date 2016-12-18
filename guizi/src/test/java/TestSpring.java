import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import guizi.user.service.UserService;

public class TestSpring {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userSer = (UserService)context.getBean("userService");
		if(userSer != null) {
			System.out.println(1);
		}else {
			System.out.println(2);
		}
	}

}
