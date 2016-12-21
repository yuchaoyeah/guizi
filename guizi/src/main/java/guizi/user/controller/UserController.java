package guizi.user.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import guizi.user.entity.User;
import guizi.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userSer;
	
	@RequestMapping("/getUser")
	public void getUser(String name,HttpServletRequest req,HttpServletResponse res) {
		User user = userSer.getUserByName(name);
		try {
			OutputStream os = res.getOutputStream();
			os.write(user.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
