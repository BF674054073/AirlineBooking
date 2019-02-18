package dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

import dao.AdminDao;
import entity.Flight;
import entity.FlightMapper;

public class AdminDaoImpl implements AdminDao {

	

	public List<Flight> findFlightByValues(String startPlace, String endPlace, Timestamp takeoffTime, String flightNumber) {
		List<Flight> flights = new ArrayList<Flight>();
		String sql = "select * from flight where ";
		boolean lock = false;
		if (startPlace != null && !startPlace.isEmpty()) {
			sql = sql + "startPlace=" + startPlace;
			lock = true;
		}
		if (endPlace != null && !endPlace.isEmpty()) {
			if (lock) {
				sql = sql + " and endPlace=" + endPlace;
			} else {
				sql = sql + "endPlace=" + endPlace;
				lock = true;
			}
		}
		if (takeoffTime != null) {
			if (lock) {
				sql = sql + " and takeoffTime=" + takeoffTime;
			} else {
				sql += " takeoffTime=" + takeoffTime;
			}
		}
		if (flightNumber != null && !flightNumber.isEmpty()) {
			if (lock) {
				sql += " and flightNumber=" + flightNumber;
			} else {
				sql += " flightNumber=" + flightNumber;
			}
		}
		
		return flights;
	}

	public static void main(String[] args) {
		AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
		List<Flight> list = adminDaoImpl.findFlightByValues("太原", "", null, null);
		if (list.size() > 1) {
			for (Flight flight : list) {
				System.out.println(list);
			}
		} else if (list.size() == 1) {
			System.out.println(list.get(0));
		}
	}
}
