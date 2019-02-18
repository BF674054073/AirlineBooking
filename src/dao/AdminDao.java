package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import entity.Flight;

public interface AdminDao {
	
	List<Flight> findFlightByValues(String startPlace, String endPlace, Timestamp takeoffTime, String flightNumber);

}
