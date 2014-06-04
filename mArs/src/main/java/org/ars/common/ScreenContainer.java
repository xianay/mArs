package org.ars.common;


import java.util.List;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * OGNL
 * @author Administrator
 *
 */
public class ScreenContainer {
	
//	private static ThreadLocal<OgnlContext> threadLocal = new ThreadLocal<OgnlContext>();
//	
//	private static OgnlContext ognlContext(){
//		if(threadLocal.get()==null)
//			threadLocal.set(new OgnlContext());
//		return threadLocal.get();
//	}
	
	private static OgnlContext context = new OgnlContext();
	
	/**
	 * 放置对象
	 * @param name
	 * @param obj
	 */
	public static void put(String name,Object obj){	
		context.put(name, obj);
	}
	
	/**
	 * clear ognlUtils data
	 */
	public static void clear(){
		context.clear();
	}
	
	/**
	 * 根据ognl表达式获得值
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getValue(String s){
		try {
			return (T) Ognl.getValue(s, context);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Parse the string #{},and put in an array
	 * @param text
	 * @param array
	 */
	public static void parseText(String text,List<String> array){
		int start = text.indexOf("${")+2;
		int end = text.indexOf("}");
		if(start>end || start==-1 || end==-1)
			return;
		String temp = text.substring(start, end);
		array.add(temp);
		String sub = text.substring(text.indexOf("}")+1);
		parseText(sub, array);
	}



}
