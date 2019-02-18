package dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import objectfactory.ObjectFactory;

import util.JDBCUtil;

import dao.OrderDao;
import entity.Flight;
import entity.Order;
import entity.OrderMapper;

public class OrderDaoImpl implements OrderDao {

	OrderDao orderDao = (OrderDao) ObjectFactory.getObject("orderdao");

	public boolean addOrderbyNumAndUser(int orderNum, Flight flight, String name, String userId, String status) throws SQLException {
		String sql = "insert into ticketOrder values(?,?,?,?,?,?,?,?,?)";
		int result = JDBCUtil.executeUpdate(sql, orderNum, flight.getFlightNumber(), flight.getStartPlace(), flight.getEndPlace(), flight.getTakeoffTime(), flight.getPrice(), name, userId, status);
		return result > 0;
	}

	public Order[] findOrderByFlightNum(String flightNumber) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Order findOrderByFlightNumAnduserId(String flightNum, String userId, Timestamp takeoffTime) throws SQLException {
		String sql = "select * from ticketOrder where flightNumber=? and id=? and takeoffTime=?";
		List<Object> query = JDBCUtil.executeQuery(sql, new OrderMapper(), flightNum, userId, takeoffTime);

		return (Order) (query.size() > 0 ? query.get(0) : null);
	}

	public Order findOrderByOrderNum(int orderNum) throws SQLException {
		String sql = "select * from ticketOrder where orderNumber=?";
		List<Object> list = JDBCUtil.executeQuery(sql, new OrderMapper(), orderNum);
		return (Order) (list.size() > 0 ? list.get(0) : null);
	}

	public Order[] findOrderByuserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updteOrder(String flightNumber, Timestamp takeoffTime) throws SQLException {

		return false;
	}

	public boolean delOrderByOrderNumber(int orderNumber) throws SQLException {
		String sql = "delete from ticketOrder where orderNumber=?";
		int result = JDBCUtil.executeUpdate(sql, orderNumber);
		return result > 0;
	}

	public boolean updateOrderStatusByOrderNumber(int orderNumber, String status) throws SQLException {
		String sql = "update ticketOrder set status=? where orderNumber=?";
		int result = JDBCUtil.executeUpdate(sql, status, orderNumber);
		return result > 0;
	}

	public List<Order> findOrderByFlightNumAndTime(String flightNumber, Timestamp timestamp) throws SQLException {
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from ticketOrder where flightNumber=? and takeoffTime=?";
		List<Object> list = JDBCUtil.executeQuery(sql, new OrderMapper(), flightNumber, timestamp);
		for (Object object : list) {
			orders.add((Order) object);
		}
		return orders;
	}
}
