package manager.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import dao.FlightDao;
import dao.OrderDao;
import dao.OrderRecordDao;

import objectfactory.ObjectFactory;
import util.Transaction;

import entity.Flight;
import entity.Order;
import exception.OrderException;
import exception.OrderRecordException;
import manager.FlightManager;
import manager.OrderManager;

public class OrderManagerImpl implements OrderManager {

	OrderDao orderDao = (OrderDao) ObjectFactory.getObject("orderdao");
	FlightDao flightDao = (FlightDao) ObjectFactory.getObject("flightdao");
	OrderRecordDao orderRecordDao = (OrderRecordDao) ObjectFactory.getObject("orderRecorddao");
	Transaction transaction = (Transaction) ObjectFactory.getObject("transaction");

	public int addOrderbyNumAndUser(Flight flight, String name, String userId, String userName, String status) throws OrderException {
		// boolean b = false;
		int orderNumber = 0;
		try {
			transaction.start();
			if (flight.getTickets() <= 0) {
				transaction.rollback();
				throw new OrderException("该航班票已售罄");
			}
			if (flight == null) {
				transaction.rollback();
				throw new OrderException("出现故障，请稍后重试");
			}
			orderNumber = (int) ((Math.random() * 9 + 1) * 10000000);
			while (true) {
				Order orderByOrderNum = orderDao.findOrderByOrderNum(orderNumber);
				if (orderByOrderNum != null) {
					orderNumber = (int) ((Math.random() * 9 + 1) * 10000000);
				} else {
					break;
				}
			}
			Order findOrderByFlightNumAnduserId = orderDao.findOrderByFlightNumAnduserId(flight.getFlightNumber(), userId, flight.getTakeoffTime());
			if (findOrderByFlightNumAnduserId != null) {
				transaction.rollback();
				throw new OrderException("请不要购买同一班机票");
			}
			boolean b = orderDao.addOrderbyNumAndUser(orderNumber, flight, name, userId, status);
			boolean updateFlightTickets = flightDao.updateFlightTickets(flight.getTickets() - 1, flight);
			if (!b && !updateFlightTickets) {
				transaction.rollback();
				throw new OrderException("订票失败");
			}
			transaction.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderNumber;
	}

	public Order[] findOrderByFlightNum(String flightNumber) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	public Order findOrderByFlightNumAnduserId(String flightNum, String userId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	public Order findOrderByOrderNum(int orderNum) throws OrderException {
		Order order = null;
		try {
			transaction.start();
			order = orderDao.findOrderByOrderNum(orderNum);
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	public Order[] findOrderByuserId(String userId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updteOrder(String flightNumber, Timestamp takeoffTime) throws OrderException {
		return false;
	}

	public boolean delOrderByOrderNum(int orderNumber) throws OrderException {
		boolean b = false;
		try {
			transaction.start();
			b = orderDao.delOrderByOrderNumber(orderNumber);
			if (!b) {
				transaction.rollback();
			}
			transaction.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean updateOrderStatusByOrderNumber(int orderNumber, String status) throws OrderException {
		boolean b = false;
		try {
			transaction.start();
			b = orderDao.updateOrderStatusByOrderNumber(orderNumber, status);
			if (!b) {
				transaction.rollback();
			}
			Order order = orderDao.findOrderByOrderNum(orderNumber);
			Flight flight = flightDao.findFlightByNumAndDate(order.getFlightNumber(), order.getTakeoffTime());
			boolean c = flightDao.updateFlightTickets(flight.getTickets() + 1, flight);
			if (!c) {
				transaction.rollback();
			}
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public List<Order> findOrderByFlightNumAndTime(String flightNumber, Timestamp timestamp) throws OrderException {
		List<Order> list = null;
		try {
			transaction.start();
			list = orderDao.findOrderByFlightNumAndTime(flightNumber, timestamp);
			if (list == null) {
				transaction.rollback();
				throw new OrderException("该航班暂时无人订");
			}
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
