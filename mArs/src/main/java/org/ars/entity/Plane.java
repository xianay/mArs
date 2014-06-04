package org.ars.entity;

import java.io.Serializable;
/**
 * plane.properties file (The corresponding data)
 * @author Administrator
 * ������,������,�����,����ʱ��,����ʱ��,ͷ�Ȳռ۸�,����ռ۸�, ���òռ۸�
 */
@SuppressWarnings("serial")
public class Plane implements Serializable{
	private String flight;//������
	private String departure;//������
	private String arrival;//�����
	private String timeOfDeparture;//����ʱ��
	private String timeOfArrival;//����ʱ��
	private Integer firstCabin;//ͷ�Ȳռ۸�
	private Integer businessCabin;//����ռ۸�
	private Integer economyCabin;//���òռ۸�
	
	
	
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
