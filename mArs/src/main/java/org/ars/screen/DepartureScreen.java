package org.ars.screen;

import java.util.List;

import org.ars.common.InputException;
import org.ars.common.ScreenContainer;
import org.ars.common.ScreenSupport;
import org.ars.common.SpringUtils;
import org.ars.common.Tools;
import org.ars.properties.PlaneProperties;
import org.ars.start.Ars;

public class DepartureScreen extends ScreenSupport{

	@Override
	protected void beforeInput() {
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String>departures = planeProperties.getDeparture();
		ScreenContainer.put("departures", departures);
		//The ognl will print out the departures data	
	
		printXML();
	}

	@Override
	protected void afertInput() throws InputException {
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String>departures = planeProperties.getDeparture();
		if(Tools.IsInputValueWithinNumber(getInput(), departures.size())){
			int i = Integer.parseInt(getInput()) -1;
			getStack().clear();
			getStack().push(departures.get(i));
			resrevation.getPlane().setDeparture(departures.get(i));
			toNextScreen("arrivalScreen");
			return;
		}
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
