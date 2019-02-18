package manager.impl;

import java.sql.SQLException;
import java.util.List;

import objectfactory.ObjectFactory;
import util.Transaction;

import dao.OrderRecordDao;

import entity.OrderRecord;
import exception.OrderRecordException;

import manager.OrderRecordManager;

public class OrderRecordManagerImpl implements OrderRecordManager {

	OrderRecordDao orderRecordDao = (OrderRecordDao) ObjectFactory.getObject("orderRecord");
	Transaction transaction = (Transaction) ObjectFactory.getObject("transaction");

	public List<OrderRecord> findOrderByUsername(String userName) {
		List<OrderRecord> list = null;
		try {
			transaction.start();
			list = orderRecordDao.findOrderNumByUserName(userName);
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean addOrderRecord(String userName, int orderNumber) throws OrderRecordException {
		boolean b = false;
		try {
			transaction.start();
			b = orderRecordDao.addOrderRecord(userName, orderNumber);
			if (!b) {
				transaction.rollback();
				throw new OrderRecordException("订单记录生成失败");
			}
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public boolean delbyorderNum(int orderNumber) throws OrderRecordException {
		boolean b = false;
		try {
			transaction.start();
			b = orderRecordDao.delbyOrderNum(orderNumber);
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public List<OrderRecord> findAll() throws OrderRecordException {
		// TODO Auto-generated method stub
		return null;
	}

}
