package org.ars.screen;

import java.util.List;

import org.ars.common.InputException;
import org.ars.common.ScreenContainer;
import org.ars.common.ScreenSupport;
import org.ars.common.SpringUtils;
import org.ars.common.Tools;
import org.ars.properties.PlaneProperties;
import org.ars.start.Ars;

public class DepartTimeScreen extends ScreenSupport{

	@Override
	protected void beforeInput() {		
		String departure = resrevation.getPlane().getDeparture();
		String arrival = resrevation.getPlane().getArrival();
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String> dtimes = planeProperties.getDeparturetimes(departure, arrival);
		ScreenContainer.put("dtimes", dtimes);
		printXML();				
	}

	@Override
	protected void afertInput() throws InputException {
		String departure = resrevation.getPlane().getDeparture();
		String arrival = resrevation.getPlane().getArrival();
		PlaneProperties planeProperties = SpringUtils.getBean("planeProperties");
		List<String> dtimes = planeProperties.getDeparturetimes(departure, arrival);
		if(Tools.IsInputValueWithinNumber(getInput(), dtimes.size())){
			int i = Integer.parseInt(getInput()) -1;
			resrevation.getPlane().setTimeOfDeparture(dtimes.get(i));
			toNextScreen("passengerAdultScreen");
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
