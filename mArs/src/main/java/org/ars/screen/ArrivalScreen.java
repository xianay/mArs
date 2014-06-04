package org.ars.screen;

import java.util.List;

import org.ars.common.InputException;
import org.ars.common.ScreenContainer;
import org.ars.common.ScreenSupport;
import org.ars.common.SpringUtils;
import org.ars.common.Tools;
import org.ars.properties.PlaneProperties;
import org.ars.start.Ars;

public class ArrivalScreen extends ScreenSupport{


	@Override
	protected void beforeInput() {
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String>arrivals = planeProperties.getArrival();
		ScreenContainer.put("arrivals", arrivals);
		//The ognl will print out the departures data	
		
		printXML();
	}

	@Override
	protected void afertInput() throws InputException {
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String>arrivals = planeProperties.getArrival();
		if(Tools.IsInputValueWithinNumber(getInput(), arrivals.size())){
			String prevInput = (String) getStack().peek();
			int i = Integer.parseInt(getInput()) - 1;
			if(prevInput.equalsIgnoreCase(arrivals.get(i)))
				throw Tools.InputException("sameAirportasDepartureException");
			resrevation.getPlane().setArrival(arrivals.get(i));
			toNextScreen("departDateScreen");
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
