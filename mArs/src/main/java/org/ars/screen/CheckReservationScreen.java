package org.ars.screen;

import org.ars.common.InputException;
import org.ars.common.ScreenSupport;
import org.ars.common.Tools;
import org.ars.start.Ars;

public class CheckReservationScreen extends ScreenSupport{

	@Override
	protected void beforeInput() {
		
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
		throw Tools.InputException("illegalInputException");
	}

	public static void main(String[] args) {
		Ars.start();
	}
	

}
