package org.ars.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tools {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * The input value is within num (1 ~ num)
	 * @param input
	 * @param num
	 * @return
	 */
	public static boolean IsInputValueWithinNumber(String input,int num){
		for(int i = 1;i<=num;i++){
			if(input.equalsIgnoreCase(String.valueOf(i)))
				return true;
		}
		return false;
	}
	

	public static InputException InputException(String name){
		return (InputException)SpringUtils.getBean(name);
	}
	
	public static Date checkInputDateFormatRight(String input) throws ParseException{
		
		return dateFormat.parse(input);
	}
	
	public static boolean isInputDateRangeRight(Date date){
		Calendar cur  = Calendar.getInstance();
		Calendar c1  = Calendar.getInstance();
		Calendar c2  = Calendar.getInstance();
		cur.setTime(date);
		c1.setTime(tomorrow(date));
		c2.setTime(nextyear(date));
		
		return c1.before(cur) && c2.after(cur);
	}
	
	public static Date tomorrow(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
	
	public static Date nextyear(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}
	
	public static String tomorrow_string(Date date){
		return dateFormat.format(tomorrow(date));
	}
	public static String nextyear_string(Date date){
		return dateFormat.format(nextyear(date));
	}
	
}
