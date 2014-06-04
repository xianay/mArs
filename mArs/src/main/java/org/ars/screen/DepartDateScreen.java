package org.ars.screen;

import java.text.ParseException;
import java.util.Date;

import org.ars.common.InputException;
import org.ars.common.ScreenContainer;
import org.ars.common.ScreenSupport;
import org.ars.common.Tools;
import org.ars.start.Ars;

public class DepartDateScreen extends ScreenSupport{

	@Override
	protected void beforeInput() {
		ScreenContainer.put("tomorrow", Tools.tomorrow_string(new Date()));
		ScreenContainer.put("nextyear", Tools.nextyear_string(new Date()));
		printXML();		
	}

	@Override
	protected void afertInput() throws InputException {
		if(getInput().equalsIgnoreCase("P")){
			toPrevScreen();
			return;
		}
		if(getInput().equalsIgnoreCase("Q")){
			quit();
			return;
		}
		try {
			Date date = Tools.checkInputDateFormatRight(getInput());
			if(Tools.isInputDateRangeRight(date))			
				toNextScreen("departTimeScreen");
			else
				throw Tools.InputException("dateRangeInputException");
		} catch (ParseException e) {
			throw Tools.InputException("dateFormatInputException");
		}
		
		//throw Tools.InputException("illegalInputException");
	}

	public static void main(String[] args) {
		Ars.start();
	}
	

}
