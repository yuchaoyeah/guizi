package guizi.core.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import commons.constants.Constants;
import guizi.user.entity.User;

public class AppFilter implements Filter{
	private List<String> exclude;

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		exclude = new ArrayList<String>();
		exclude.add("/guizi/user/toLogin.do");
		exclude.add("/guizi/user/login.do");
		exclude.add("/guizi/user/toRegister.do");
		exclude.add("/guizi/user/register.do");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		HttpSession session = httprequest.getSession();
		
		User user = (User)session.getAttribute(Constants.sessionUserKey);
		System.out.println(httprequest.getRequestURL().toString());
		System.out.println(httprequest.getRequestURI());
		if(exclude.contains(httprequest.getRequestURI())) {
			chain.doFilter(request, response);
			return;
		}else if(user != null) {
			chain.doFilter(request, response);
			return;
		}else {
			httpresponse.sendRedirect("/guizi/home.do");
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
