package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.RowMapperObject;

public class FlightMapper implements RowMapperObject {

	public Object rowMapperObject(ResultSet rs) throws SQLException {
		Flight flight = new Flight();

		flight.setFlightNumber(rs.getString("flightNumber"));
		flight.setStartPlace(rs.getString("startPlace"));
		flight.setEndPlace(rs.getString("endPlace"));
		flight.setTakeoffTime(rs.getTimestamp("takeoffTime"));
		flight.setFlyingTime(rs.getString("flyingTime"));
		flight.setTickets(rs.getInt("tickets"));
		flight.setPrice(rs.getDouble("price"));
		return flight;
	}
}
