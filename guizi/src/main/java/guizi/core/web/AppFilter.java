package guizi.core.web;

import java.io.IOException;

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

public class AppFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		HttpSession session = httprequest.getSession();
		
		String seesionUserKey = (String)session.getAttribute(Constants.sessionUserKey);
		if(StringUtils.contains(httprequest.getRequestURI(), "/login.do") || StringUtils.isNotBlank(seesionUserKey)) {
			chain.doFilter(request, response);
			return;
		}
		
		httpresponse.sendRedirect("");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
