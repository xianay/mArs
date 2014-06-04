package org.ars.entity;

import java.io.Serializable;
/**
 * plane.properties file (The corresponding data)
 * @author Administrator
 * 航班名,出发地,到达地,出发时间,到达时间,头等舱价格,商务舱价格, 经济舱价格
 */
@SuppressWarnings("serial")
public class Plane implements Serializable{
	private String flight;//航班名
	private String departure;//出发地
	private String arrival;//到达地
	private String timeOfDeparture;//出发时间
	private String timeOfArrival;//到达时间
	private Integer firstCabin;//头等舱价格
	private Integer businessCabin;//商务舱价格
	private Integer economyCabin;//经济舱价格
	
	
	
	@Override
	public String toString() {
		return "Plane [flight=" + flight + ", departure=" + departure
				+ ", arrival=" + arrival + ", timeOfDeparture="
				+ timeOfDeparture + ", timeOfArrival=" + timeOfArrival
				+ ", firstCabin=" + firstCabin + ", businessCabin="
				+ businessCabin + ", economyCabin=" + economyCabin + "]";
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getTimeOfDeparture() {
		return timeOfDeparture;
	}
	public void setTimeOfDeparture(String timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}
	public String getTimeOfArrival() {
		return timeOfArrival;
	}
	public void setTimeOfArrival(String timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	public Integer getFirstCabin() {
		return firstCabin;
	}
	public void setFirstCabin(Integer firstCabin) {
		this.firstCabin = firstCabin;
	}
	public Integer getBusinessCabin() {
		return businessCabin;
	}
	public void setBusinessCabin(Integer businessCabin) {
		this.businessCabin = businessCabin;
	}
	public Integer getEconomyCabin() {
		return economyCabin;
	}
	public void setEconomyCabin(Integer economyCabin) {
		this.economyCabin = economyCabin;
	}
	
	
}
