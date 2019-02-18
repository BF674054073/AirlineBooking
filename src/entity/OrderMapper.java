package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import util.RowMapperObject;

public class OrderMapper implements RowMapperObject {

	public Object rowMapperObject(ResultSet rs) throws SQLException {
		Order order = new Order();
		order.setOrderNumber(rs.getInt("orderNumber"));
		order.setFlightNumber(rs.getString("flightNumber"));
		order.setStartPlace(rs.getString("startPlace"));
		order.setEndPlace(rs.getString("endPlace"));
		order.setTakeoffTime(Timestamp.valueOf(rs.getString("takeoffTime")));
		order.setPrice(rs.getFloat("price"));
		order.setName(rs.getString("name"));
		order.setId(rs.getString("id"));
		order.setStatus(rs.getString("status"));
		return order;
	}

}
