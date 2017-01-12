package guizi;

import guizi.user.entity.User;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import commons.constants.Constants;

@Controller
public class BaseController {
	
	public static void responseJson(HttpServletResponse res,String json) {
		responseJson(res, json, "utf-8");
	}
	
	public static void responseJson(HttpServletResponse res,String json,String charset) {
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("application/json");
		res.setCharacterEncoding(charset);
		try(OutputStream os = res.getOutputStream()) {
			os.write(json.getBytes(charset));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getCurrentUser(HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute(Constants.sessionUserKey);
		return user;
	}
}
