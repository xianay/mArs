package org.ars.properties;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.ars.common.PropertiesSupport;
import org.ars.entity.Plane;

/**
 * plane.properties data access object (mapping)
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class PlaneProperties extends PropertiesSupport{
	
	private List<Plane> planes;
	
	public PlaneProperties(String file) {
		super(file);
		init();
	}
	
	/**
	 * Convert string info to plane object
	 */
	private void init(){
		if(planes==null){
			planes = new ArrayList<Plane>();
			for(String s : this){
				Plane plane = new Plane();
				Field[] fields = plane.getClass().getDeclaredFields();
				String[] arr = s.split(",");
				for(int i = 0;i<fields.length;i++){
					String name = fields[i].getName();
					try {
						BeanUtils.setProperty(plane, name, arr[i]);
					} catch (Exception e) {	
						e.printStackTrace();
					}
				}
				planes.add(plane);				
			}
		}
	}
	
	/**
	 * get plane departure
	 * @return
	 */
	public List<String> getDeparture(){
		List<String> departures = new ArrayList<String>();
		for(Plane plane : planes){
			if(!departures.contains(plane.getDeparture())){
				departures.add(plane.getDeparture());
			}
		}
		return departures;
	}
	
	/**
	 * get plane arrival
	 * @return
	 */
	public List<String> getArrival(){
		List<String> arrivals = new ArrayList<String>();
		for(Plane plane : planes){
			if(!arrivals.contains(plane.getArrival())){
				arrivals.add(plane.getArrival());
			}
		}
		return arrivals;
	}
	
	/**
	 * 
	 * @param departure
	 * @param arrival
	 * @return
	 */
	public List<String> getDeparturetimes(String departure,String arrival){
		List<String> departuretimes = new ArrayList<String>();
		for(Plane plane : planes){
			if(plane.getDeparture().equals(departure)&&plane.getArrival().equals(arrival)){
				departuretimes.add(plane.getTimeOfDeparture());
			}
		}		
		return departuretimes;
	}
	
//	public static void main(String[] args) throws Exception {
//		SpringUtils.build();
//		PlaneProperties planeProperties= SpringUtils.getBean("planeProperties");
//		Plane[] planes = planeProperties.getPlanes();
//		for (Plane plane : planes) {
//			System.out.println(plane);
//		}
//	}

}
