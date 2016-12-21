package commons.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		if(applicationContext != null) {
			return applicationContext.getBean(clazz);
		}else {
			System.out.println("------applicationContext is null!");
			return null;
		}
	}
}
