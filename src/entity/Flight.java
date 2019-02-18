package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 航班
 * 
 * @author soft01
 * 
 */
public class Flight {
	/**
	 * 航班号
	 */
	private String flightNumber;
	/**
	 * 出发时间
	 */
	private Timestamp takeoffTime;
	/**
	 * 飞行时间
	 */
	private String flyingTime;
	/**
	 * 出发地
	 */
	private String startPlace;
	/**
	 * 目的地
	 */
	private String endPlace;
	/**
	 * 是否有票
	 */
	private int tickets;
	/**
	 * 票价
	 */
	private double price;

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightNumber, Timestamp takeoffTime, String flyingTime, String startPlace, String endPlace, int tickets, double price) {
		super();
		this.flightNumber = flightNumber;
		this.takeoffTime = takeoffTime;
		this.flyingTime = flyingTime;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.tickets = tickets;
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Timestamp getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(Timestamp takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public String getFlyingTime() {
		return flyingTime;
	}

	public void setFlyingTime(String flyingTime) {
		this.flyingTime = flyingTime;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String toString() {
		return flightNumber + "\t" + startPlace + "\t" + endPlace + "\t" + sdf.format(takeoffTime) + "\t" + flyingTime + "\t" + tickets + "\t" + price;
	}
}
