package org.ars.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Springframework main class
 * @author Administrator
 *
 */
public class SpringUtils {
	
	private static ApplicationContext context;
	
	/**
	 * initialization Springframework
	 */
	public static synchronized void build(){
		if(context==null)
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * get spring bean object
	 * @param name spring name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		return (T) context.getBean(name);
	}
	
}
