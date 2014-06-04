package org.ars.screen;

import org.ars.common.InputException;
import org.ars.common.ScreenSupport;
import org.ars.common.Tools;
import org.ars.start.Ars;

public class ReviewScreen extends ScreenSupport{

	@Override
	protected void beforeInput() {		
		printXML();		
	}

	@Override
	protected void afertInput() throws InputException {
		if(getInput().equalsIgnoreCase("1")){
			toNextScreen("departureScreen");
			return;
		}
		if(getInput().equalsIgnoreCase("2")){
			toNextScreen("checkReservationScreen");
			return;
		}
		if(getInput().equalsIgnoreCase("Q")){
			quit();
			return;
		}
		throw Tools.InputException("illegalInputException");
	}

	public static void main(String[] args) {
		Ars.start();
	}
	

}
