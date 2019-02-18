package entity;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
	/**
	 * 订单号
	 */
	private int orderNumber;
	/**
	 * 航班号
	 */
	private String flightNumber;
	/**
	 * 出发地
	 */
	private String startPlace;
	/**
	 * 目的地
	 */
	private String endPlace;
	/**
	 * 票价
	 */
	private double price;
	/**
	 * 乘客姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String id;
	/**
	 * 出发时间
	 */
	private Timestamp takeoffTime;
	/**
	 * 订票状态
	 */
	private String status;

	public Order() {

	}

	public Order(int orderNumber, String flightNumber, String startPlace, String endPlace, double price, String name, String id, Timestamp takeoffTime, String status) {
		super();
		this.orderNumber = orderNumber;
		this.flightNumber = flightNumber;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.price = price;
		this.name = name;
		this.id = id;
		this.takeoffTime = takeoffTime;
		this.status = status;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(Timestamp takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return orderNumber + "\t" + flightNumber + "\t" + startPlace + "\t" + endPlace + "\t" + takeoffTime + "\t" + price + "\t" + name + "\t" + id + "\t" + status;
	}

}
