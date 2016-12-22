package guizi.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import commons.bean.Msg;
import commons.constants.Constants;
import commons.utils.MathUtils;
import guizi.user.entity.User;
import guizi.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserOpController {
	@Autowired
	private UserService userSer;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Msg register(String username,String password,HttpServletRequest req) {
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return Msg.createFailMsg("用户名或者密码不能为空！");
		}
		//用户名、密码字符限制...
		
		User user = new User(username.trim(),MathUtils.MD5(password.trim()));
		userSer.save(user);
		return Msg.createScuMsg();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Msg login(HttpServletRequest req,HttpServletResponse res) {
		String account = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
			return Msg.createFailMsg("用户名或者密码为空！");
		}
		User user = userSer.getUserByProperty("account",account);
		if(user == null) {
			return Msg.createFailMsg("用户不存在！");
		}
		if(!StringUtils.equals(MathUtils.MD5(password), user.getPassword())) {
			return Msg.createFailMsg("密码错误！");
		}
		
		HttpSession session = req.getSession();
		session.setAttribute(Constants.sessionUserKey, user);
		return Msg.createScuMsg();
	}
}
